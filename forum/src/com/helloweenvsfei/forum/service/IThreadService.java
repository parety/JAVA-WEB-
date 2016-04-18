package com.helloweenvsfei.forum.service;

import com.helloweenvsfei.forum.bean.Thread;

public interface IThreadService<T extends Thread> extends IService<T> {

	public void updateHit(Integer threadId);

}
