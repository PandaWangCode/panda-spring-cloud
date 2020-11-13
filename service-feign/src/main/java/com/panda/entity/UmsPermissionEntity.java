package com.panda.entity;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

/**
 * Ȩ��
 * @author DELL
 *
 */
public class UmsPermissionEntity implements Serializable {
    private Long id;

    @ApiModelProperty(value = "����Ȩ��id")
    private Long pid;

    @ApiModelProperty(value = "����")
    private String name;

    @ApiModelProperty(value = "Ȩ��ֵ")
    private String value;

    @ApiModelProperty(value = "ͼ��")
    private String icon;

    @ApiModelProperty(value = "Ȩ�����ͣ�0->Ŀ¼��1->�˵���2->��ť���ӿڰ�Ȩ�ޣ�")
    private Integer type;

    @ApiModelProperty(value = "ǰ����Դ·��")
    private String uri;

    @ApiModelProperty(value = "����״̬��0->���ã�1->����")
    private Integer status;

    @ApiModelProperty(value = "����ʱ��")
    private Date createTime;

    @ApiModelProperty(value = "����")
    private Integer sort;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", pid=").append(pid);
        sb.append(", name=").append(name);
        sb.append(", value=").append(value);
        sb.append(", icon=").append(icon);
        sb.append(", type=").append(type);
        sb.append(", uri=").append(uri);
        sb.append(", status=").append(status);
        sb.append(", createTime=").append(createTime);
        sb.append(", sort=").append(sort);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
