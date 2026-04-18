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

## 核心功能模块

- **用户管理**: 注册、登录（支持 QQ 登录）、邮箱验证码。
- **文件管理**: 上传、分片上传、断点续传、下载、移动、重命名、删除等。
- **回收站**: 文件彻底删除与还原。
- **分享管理**: 创建分享链接、提取码验证。
- **管理后台**: 系统设置、全站文件管理等。

## 核心技术亮点
- 项目已开启 **虚拟线程 (Virtual Threads)**，大幅提升并发处理能力。
- 结合 `GlobalOperationAspect` 实现自动化参数校验和登录状态校验。
