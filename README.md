# netdisk - 网盘管理系统

netdisk 是一个基于 Spring Boot 3 开发的网盘后台系统，支持大文件上传、分片上传、断点续传、在线预览等功能。

## 技术栈

- **核心框架**: Spring Boot 3.3.4
- **持久层**: MyBatis (MyBatis-Spring-Boot-Starter 3.0.3)
- **数据库**: MySQL 8.0
- **缓存/Session**: Redis (Jedis)
- **通讯**: OKHttp 3
- **工具库**: Fastjson2, Apache Commons Lang3/IO/Codec

## 项目规范与说明

### MyBatis 框架的映射文件
1. **作用**: MyBatis 框架的映射文件（Mapper XML）是 MyBatis 框架的核心，用于定义 SQL 语句、结果映射以及数据库与 Java 对象之间的映射关系。
2. **路径**: `mapper.xml` 的 namespace **必须对应** Mapper 接口的全限定类名（`package.classname`），且 `resources` 目录下的 XML 文件路径应与 `java` 目录下的 Mapper 接口路径保持一致。

### MySQL
1. **自动化**: 支持数据库自动初始化，无需手动执行建表脚本，建议成功建立数据库后修改初始化模式为 `never`。
2. **操作**: 
   - 本地启动/关闭数据库: `net start/stop mysql`
   - 验证数据库连接端口: `netstat -ano | findstr :3306`

### 开发环境要求
- **JDK**: 21 (支持虚拟线程)
- **Maven**: 3.6+
- **编码**: 默认编码为 `UTF-8`
- **FFmpeg**: 用于视频处理，建议安装并配置好全局 FFmpeg 路径。

## 快速开始

### 1. 数据库准备
- 执行 `src/main/resources/schema.sql` 脚本到 MySQL。
- 确保 `application.yml` 中的数据库账号密码正确。

### 2. 配置文件说明 (`application.yml`)
- **文件存储**: 修改 `project.folder` 为你本地的上传目录。
- **邮件服务**: 配置 `spring.mail` 相关信息以支持邮箱验证码。
- **QQ 登录**: 配置 `qq.app` 相关参数。

### 3. 日志查看
日志输出在控制台和 `logs/` 目录下。若终端输出乱码，请在 Windows 终端执行 `chcp 65001`。

## 多环境配置

本项目采用 Spring Boot 的多环境配置机制，包含以下配置文件：

### 配置文件结构
- `application.yml` - 基础配置文件，包含所有环境共享的配置
- `application-dev.yml` - 开发环境配置文件
- `application-prod.yml` - 生产环境配置文件

### 环境配置说明

#### 开发环境 (application-dev.yml)
- 端口：7090
- 数据库：单个本地 MySQL
- Redis：单个本地 Redis
- 日志级别：debug
- 上传路径：本地开发路径
- QQ登录回调：本地回调地址

#### 生产环境 (application-prod.yml)
- 端口：8080
- 数据库：使用 ProxySQL 代理（后端为 MySQL 一主一从架构）
- Redis：一主一从+哨兵模式
- 日志级别：info
- 上传路径：服务器路径
- QQ登录回调：生产环境回调地址

### 如何使用

#### 1. 开发环境启动
```bash
# 方法1：使用默认配置（默认使用开发环境）
mvn spring-boot:run

# 方法2：明确指定环境
mvn spring-boot:run -Dspring.profiles.active=dev
```

#### 2. 生产环境启动
```bash
# 方法1：使用环境变量启动
PROXYSQL_HOST=proxysql地址 PROXYSQL_PORT=6033 \
DB_NAME=netdisk DB_USERNAME=用户名 DB_PASSWORD=密码 \
REDIS_SENTINEL_MASTER=mymaster \
REDIS_SENTINEL_NODES=127.0.0.1:26379,127.0.0.1:26380,127.0.0.1:26381 \
MAIL_USERNAME=邮箱 MAIL_PASSWORD=邮箱密码 \
QQ_APP_ID=QQ应用ID QQ_APP_KEY=QQ应用密钥 \
UPLOAD_FOLDER=/opt/netdisk/upload-file \
java -jar target/netdisk-1.0.jar --spring.profiles.active=prod

# 方法2：在服务器上配置环境变量后启动
java -jar target/netdisk-1.0.jar --spring.profiles.active=prod
```

### 生产环境部署建议

1. **环境变量配置**：在生产服务器上配置以下环境变量
   - `PROXYSQL_HOST` - ProxySQL主机地址
   - `PROXYSQL_PORT` - ProxySQL端口（默认6033）
   - `DB_NAME` - 数据库名称
   - `DB_USERNAME` - 数据库用户名
   - `DB_PASSWORD` - 数据库密码
   - `REDIS_SENTINEL_MASTER` - Redis哨兵主节点名称
   - `REDIS_SENTINEL_NODES` - Redis哨兵节点列表（逗号分隔）
   - `MAIL_USERNAME` - 邮件发送账号
   - `MAIL_PASSWORD` - 邮件发送密码
   - `QQ_APP_ID` - QQ登录应用ID
   - `QQ_APP_KEY` - QQ登录应用密钥
   - `UPLOAD_FOLDER` - 文件上传目录

2. **ProxySQL 配置**：
   - 安装并配置 ProxySQL
   - 添加后端 MySQL 实例（1主1从）
   - 配置读写分离规则：写操作路由到主库，读操作路由到从库
   - 配置从库负载均衡策略
   - 确保 ProxySQL 高可用

3. **MySQL 主从配置**：
   - 主库：3306端口
   - 从库1：3307端口
   - 从库2：3308端口
   - 确保主从复制正常工作
   - 生产环境启用SSL连接

4. **Redis 哨兵配置**：
   - 主节点：默认使用哨兵监控的主节点
   - 哨兵节点：26379、26380、26381端口
   - 确保哨兵集群正常运行

4. **安全配置**：
   - 生产环境数据库密码必须使用强密码
   - 生产环境应启用SSL连接
   - 定期备份数据库
   - 配置防火墙限制数据库和Redis访问

5. **性能优化**：
   - 生产环境Hikari连接池配置已优化
   - 生产环境Redis连接池配置已优化
   - 生产环境日志级别设置为info，减少日志输出

## 核心功能模块

- **用户管理**: 注册、登录（支持 QQ 登录）、邮箱验证码。
- **文件管理**: 上传、分片上传、断点续传、下载、移动、重命名、删除等。
- **回收站**: 文件彻底删除与还原。
- **分享管理**: 创建分享链接、提取码验证。
- **管理后台**: 系统设置、全站文件管理等。

## 核心技术亮点
- 项目已开启 **虚拟线程 (Virtual Threads)**，大幅提升并发处理能力。
- 结合 `GlobalOperationAspect` 实现自动化参数校验和登录状态校验。
