package com.xiexj.ebook;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.graphics.Paint;
import android.os.Bundle;

public class MyBook extends Activity {
	
	private BookLayout blo;
	//测试新的分支。
	private int[] imgs = {
			R.drawable.book_cover,
			-1,
			R.drawable.book_page_1,
			R.drawable.book_page_2,
			R.drawable.book_page3,
			R.drawable.book_page_4,
			R.drawable.book_page_5,
			R.drawable.book_page_6,
			R.drawable.author,
			R.drawable.book_back_cover
	};
	
//	private String content = " 测试 ";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidUtils.setFullNoTitleScreen(this);
		blo = new BookLayout(this);
		List<SinglePage> singlePageList = new ArrayList<SinglePage>();
		boolean isLeft = false;
		int num = 0;
		for(int i=0;i<imgs.length;i++){
			PageContent content = new PageContent(this,imgs[i],blo);
			if(i==0||i==imgs.length-2||i==imgs.length-1){
				content.setCover(true);
			}else if(i!=1){
				content.setContentPage(true);
				content.setContentId(num++);
			}
			SinglePage page = new SinglePage(this,isLeft,i,blo,content);
			singlePageList.add(page);
			isLeft = !isLeft;
		}
		Paint m_paint = new Paint();
//		blo.setContentList(AndroidUtils.getPageContentStringInfo(m_paint, content, PageContent.getPageContentLine(BookLayout.PAGE_HEIGHT), PageContent.getPageContentWidth(BookLayout.PAGE_WIDTH)));
		blo.setPageList(singlePageList, -1);
		setContentView(blo);
	}
}
