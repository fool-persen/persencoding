package com.persen.beijing.springmybatis.service.impl;

import com.persen.beijing.springmybatis.biz.Transaction;
import com.persen.beijing.springmybatis.service.ItemService;

public class ItemServiceImpl implements ItemService {
    Transaction transaction;

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public void deal() {
        transaction.doItem();
    }
//	
//	public CodeActAcctItemMapper getItem() {
//		return item;
//	}
//
//	public void setItem(CodeActAcctItemMapper item) {
//		this.item = item;
//	}
//
//	@Override
//	public int countAll() {
//		return item.countAll();
//	}
//
//	@Override
//	public CodeActAcctItem select(int acct_item_code) {
//		return item.select(acct_item_code);
//	}
//
//	@Override
//	public int insert(CodeActAcctItem caai) {
//		return item.insert(caai);
//	}
//
//	@Override
//	public int update(CodeActAcctItem caai) {
//		return item.update(caai);
//	}
//
//	@Override
//	public int delete(CodeActAcctItem caai) {
//		return item.delete(caai);
//	}

}
