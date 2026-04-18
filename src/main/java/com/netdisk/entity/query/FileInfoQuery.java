package com.netdisk.entity.query;

/**
 * 文件信息参数
 */
public class FileInfoQuery extends BaseParam {


    /**
     * 文件ID
     */
    private String fileId;

    private String fileIdFuzzy;

    /**
     * 用户ID
     */
    private String userId;

    private String userIdFuzzy;

    /**
     * md5值，第一次上传记�?
     */
    private String fileMd5;

    private String fileMd5Fuzzy;

    /**
     * 父级ID
     */
    private String filePid;

    private String filePidFuzzy;

    /**
     * 文件大小
     */
    private Long fileSize;

    /**
     * 文件名称
     */
    private String fileName;

    private String fileNameFuzzy;

    /**
     * 封面
     */
    private String fileCover;

    private String fileCoverFuzzy;

    /**
     * 文件路径
     */
    private String filePath;

    private String filePathFuzzy;

    /**
     * 创建时间
     */
    private String createTime;

    private String createTimeStart;

    private String createTimeEnd;

    /**
     * 最后更新时�?
     */
    private String lastUpdateTime;

    private String lastUpdateTimeStart;

    private String lastUpdateTimeEnd;

    /**
     * 0:文件 1:目录
     */
    private Integer folderType;

    /**
     * 1:视频 2:音频  3:图片 4:文档 5:其他
     */
    private Integer fileCategory;

    /**
     * 1:视频 2:音频  3:图片 4:pdf 5:doc 6:excel 7:txt 8:code 9:zip 10:其他
     */
    private Integer fileType;

    /**
     * 0:转码�?1转码失败 2:转码成功
     */
    private Integer status;

    /**
     * 回收站时�?
     */
    private String recoveryTime;

    private String recoveryTimeStart;

    private String recoveryTimeEnd;

    /**
     * 删除标记 0:删除  1:回收�? 2:正常
     */
    private Integer delFlag;

    private String[] fileIdArray;

    private String[] filePidArray;

    private String[] excludeFileIdArray;

    private Boolean queryExpire;

    private Boolean queryNickName;


    public Boolean getQueryNickName() {
        return queryNickName;
    }

    public void setQueryNickName(Boolean queryNickName) {
        this.queryNickName = queryNickName;
    }

    public Boolean getQueryExpire() {
        return queryExpire;
    }

    public void setQueryExpire(Boolean queryExpire) {
        this.queryExpire = queryExpire;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getFileId() {
        return this.fileId;
    }

    public void setFileIdFuzzy(String fileIdFuzzy) {
        this.fileIdFuzzy = fileIdFuzzy;
    }

    public String getFileIdFuzzy() {
        return this.fileIdFuzzy;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserIdFuzzy(String userIdFuzzy) {
        this.userIdFuzzy = userIdFuzzy;
    }

    public String getUserIdFuzzy() {
        return this.userIdFuzzy;
    }

    public void setFileMd5(String fileMd5) {
        this.fileMd5 = fileMd5;
    }

    public String getFileMd5() {
        return this.fileMd5;
    }

    public void setFileMd5Fuzzy(String fileMd5Fuzzy) {
        this.fileMd5Fuzzy = fileMd5Fuzzy;
    }

    public String getFileMd5Fuzzy() {
        return this.fileMd5Fuzzy;
    }

    public void setFilePid(String filePid) {
        this.filePid = filePid;
    }

    public String getFilePid() {
        return this.filePid;
    }

    public void setFilePidFuzzy(String filePidFuzzy) {
        this.filePidFuzzy = filePidFuzzy;
    }

    public String getFilePidFuzzy() {
        return this.filePidFuzzy;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    public Long getFileSize() {
        return this.fileSize;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return this.fileName;
    }

    public void setFileNameFuzzy(String fileNameFuzzy) {
        this.fileNameFuzzy = fileNameFuzzy;
    }

    public String getFileNameFuzzy() {
        return this.fileNameFuzzy;
    }

    public void setFileCover(String fileCover) {
        this.fileCover = fileCover;
    }

    public String getFileCover() {
        return this.fileCover;
    }

    public void setFileCoverFuzzy(String fileCoverFuzzy) {
        this.fileCoverFuzzy = fileCoverFuzzy;
    }

    public String getFileCoverFuzzy() {
        return this.fileCoverFuzzy;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public void setFilePathFuzzy(String filePathFuzzy) {
        this.filePathFuzzy = filePathFuzzy;
    }

    public String getFilePathFuzzy() {
        return this.filePathFuzzy;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public void setCreateTimeStart(String createTimeStart) {
        this.createTimeStart = createTimeStart;
    }

    public String getCreateTimeStart() {
        return this.createTimeStart;
    }

    public void setCreateTimeEnd(String createTimeEnd) {
        this.createTimeEnd = createTimeEnd;
    }

    public String getCreateTimeEnd() {
        return this.createTimeEnd;
    }

    public void setLastUpdateTime(String lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getLastUpdateTime() {
        return this.lastUpdateTime;
    }

    public void setLastUpdateTimeStart(String lastUpdateTimeStart) {
        this.lastUpdateTimeStart = lastUpdateTimeStart;
    }

    public String getLastUpdateTimeStart() {
        return this.lastUpdateTimeStart;
    }

    public void setLastUpdateTimeEnd(String lastUpdateTimeEnd) {
        this.lastUpdateTimeEnd = lastUpdateTimeEnd;
    }

    public String getLastUpdateTimeEnd() {
        return this.lastUpdateTimeEnd;
    }

    public void setFolderType(Integer folderType) {
        this.folderType = folderType;
    }

    public Integer getFolderType() {
        return this.folderType;
    }

    public void setFileCategory(Integer fileCategory) {
        this.fileCategory = fileCategory;
    }

    public Integer getFileCategory() {
        return this.fileCategory;
    }

    public void setFileType(Integer fileType) {
        this.fileType = fileType;
    }

    public Integer getFileType() {
        return this.fileType;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setRecoveryTime(String recoveryTime) {
        this.recoveryTime = recoveryTime;
    }

    public String getRecoveryTime() {
        return this.recoveryTime;
    }

    public void setRecoveryTimeStart(String recoveryTimeStart) {
        this.recoveryTimeStart = recoveryTimeStart;
    }

    public String getRecoveryTimeStart() {
        return this.recoveryTimeStart;
    }

    public void setRecoveryTimeEnd(String recoveryTimeEnd) {
        this.recoveryTimeEnd = recoveryTimeEnd;
    }

    public String getRecoveryTimeEnd() {
        return this.recoveryTimeEnd;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public Integer getDelFlag() {
        return this.delFlag;
    }

    public String[] getFileIdArray() {
        return fileIdArray;
    }

    public void setFileIdArray(String[] fileIdArray) {
        this.fileIdArray = fileIdArray;
    }

    public String[] getExcludeFileIdArray() {
        return excludeFileIdArray;
    }

    public void setExcludeFileIdArray(String[] excludeFileIdArray) {
        this.excludeFileIdArray = excludeFileIdArray;
    }

    public String[] getFilePidArray() {
        return filePidArray;
    }

    public void setFilePidArray(String[] filePidArray) {
        this.filePidArray = filePidArray;
    }
}
