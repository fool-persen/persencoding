package com.persen.beijing.springmybatis.biz;

import com.persen.beijing.springmybatis.dao.CodeActAcctItemMapper;
import com.persen.beijing.springmybatis.po.CodeActAcctItem;

public class Transaction {
    private CodeActAcctItemMapper item;

    public CodeActAcctItemMapper getItem() {
        return item;
    }

    public void setItem(CodeActAcctItemMapper item) {
        this.item = item;
    }

    public void doItem() {
//		int res = item.countAll();
//		System.out.println(res);
        int item_code = 116;
        CodeActAcctItem caai = new CodeActAcctItem();
        caai.setAcct_item_code(item_code);

        caai = item.select1(caai);
        System.out.println(caai);


//		item_code = 10001;
//		caai.setAcct_item_code(item_code);
//		item.insert(caai);
//		System.out.println(caai);
//		try {
//			Thread.sleep(1000*10);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		caai.setAcct_item_name("persen");
//		item.update(caai);
//		System.out.println(caai);
    }


}
