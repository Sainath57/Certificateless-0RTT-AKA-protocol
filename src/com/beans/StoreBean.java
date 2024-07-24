package com.beans;

import java.io.InputStream;

public class StoreBean {
private String uid,cid,enc,content,filename,filedata,sessionkey,fid;
private InputStream photo1;

public String getUid() {
	return uid;
}
public void setUid(String uid) {
	this.uid = uid;
}
public String getCid() {
	return cid;
}
public void setCid(String cid) {
	this.cid = cid;
}
public String getEnc() {
	return enc;
}
public void setEnc(String enc) {
	this.enc = enc;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public String getFilename() {
	return filename;
}
public void setFilename(String filename) {
	this.filename = filename;
}
public String getFiledata() {
	return filedata;
}
public void setFiledata(String filedata) {
	this.filedata = filedata;
}
public String getSessionkey() {
	return sessionkey;
}
public void setSessionkey(String sessionkey) {
	this.sessionkey = sessionkey;
}
public String getFid() {
	return fid;
}
public void setFid(String fid) {
	this.fid = fid;
}
public InputStream getPhoto() {
	return photo1;
}
public void setPhoto1(InputStream photo1) {
	this.photo1 = photo1;
}
}
