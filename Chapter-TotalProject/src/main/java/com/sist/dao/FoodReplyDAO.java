package com.sist.dao;
import java.util.*;
import com.sist.mapper.*;
import com.sist.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sist.mapper.FoodReplyMapper;
@Repository
public class FoodReplyDAO {
	@Autowired
	private FoodReplyMapper mapper;
	
	public String isLogin(String id,String pwd)
	{
		String result="";
		//1.id체크
		int count=mapper.idCount(id);
		if(count==0) //ID가 없다
		{
			result="NOID";
			
		}
		else//ID가 있다
		{
			String data=mapper.memberGetPwdAndName(id);
			StringTokenizer st=new StringTokenizer(data,",");
			String db_pwd=st.nextToken();
			String name=st.nextToken();
			if(db_pwd.equals(pwd))//로그인 된 상태
			{
				result=name;
			}
			else//비밀번호가 틀렸을 때
			{
				result="NOPWD";
			}
		}
		return result;
	}
	public List<FoodReplyVO> replyListData(int fno)
	{
		return mapper.replyListData(fno);
	}
	public void replyInsert(FoodReplyVO vo)
	{
		mapper.replyInsert(vo);
	}
	public void replyUpdate(FoodReplyVO vo)
	{
		mapper.replyUpdate(vo);
	}
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
	public void replyReplyInsert(int pno,FoodReplyVO vo)
	{
		//1.상위(답변 대상의 정보읽기)
		FoodReplyVO pvo = mapper.replyParentInfoData(pno);
		//2. group_step+1
		mapper.replyGroupStepIncrement(pvo);
		//3. insert
		vo.setGroup_id(pvo.getGroup_id());
		vo.setGroup_step(pvo.getGroup_step()+1);
		vo.setGroup_tab(pvo.getGroup_tab()+1);
		vo.setRoot(pno);
		mapper.replyReplyInsert(vo);
		//4. depth증가
		mapper.replyDepthIncrement(pno);
	}
	
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
	//propagation에서 REQUIRED는 DEFAULT값이므로 사실 생략이 가능하다
	public void replyDelete(int no)
	{
		FoodReplyVO vo=mapper.replyInfoData(no);
		if(vo.getDepth()==0)
		{
			mapper.replyDelete(no);
		}
		else
		{
			mapper.replyMsgUpdate(no);
		}
		mapper.replyDepthDecrement(vo.getRoot());
		//본인 꺼를 바꾸는 것이 아니라 상위의 것을 바꿔줘야한다(본인꺼는 삭제되었으니까)
		//마지막에 commit이 되기때문에 일괄처리가 되는것(각 부분에서 오류시에는 그부분에서 rollback)
	}
}
