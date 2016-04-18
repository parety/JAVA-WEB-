package com.helloweenvsfei.forum.service.impl;

import com.helloweenvsfei.forum.bean.Reply;
import com.helloweenvsfei.forum.service.IReplyService;

public class ReplyServiceImpl<T extends Reply> extends ServiceImpl<T> implements
		IReplyService<T> {

	@Override
	public void create(T reply) {

		dao.create(reply);

		// 更新帖子最后回复、最后回复日期、作者、回帖数
		int count = dao.getTotalCount(" select count(r) from Reply r "
				+ " where r.deleted = false and r.thread.id = "
				+ reply.getThread().getId(), null);

		dao.createQuery(
				" update Thread t "
						+ " set t.authorLastReplied.id = :authorLastReplied, "
						+ " t.dateLastReplied = :dateLastReplied, "
						+ " t.replyCount = :replyCount "
						+ " where t.id = :threadId ").setParameter(
				"authorLastReplied", reply.getAuthor().getId()).setParameter(
				"dateLastReplied", reply.getDateCreated()).setParameter(
				"replyCount", count).setParameter("threadId",
				reply.getThread().getId()).executeUpdate();

		// 更新版面的最后发表数、最后发表时间
		int replyCount = dao.getTotalCount(" select count(r) from Reply r "
				+ " where r.deleted = false " + " and r.thread.board.id = "
				+ reply.getThread().getBoard().getId(), null);

		dao.createQuery(
				" update Board b " + " set b.lastThread.id = null, "
						+ " b.lastReply.id = :lastReplyId, "
						+ " b.replyCount = :replyCount "
						+ " where b.id = :boardId ").setParameter(
				"lastReplyId", reply.getId()).setParameter("boardId",
				reply.getThread().getBoard().getId()).setParameter(
				"replyCount", replyCount).executeUpdate();

		int floor = dao.getTotalCount(" select count(r) from Reply r "
				+ " where r.thread.id = " + reply.getThread().getId(), null);

		// 回帖处于第几楼
		reply.setFloor(floor);
		
		dao.save(reply);
	}
}
