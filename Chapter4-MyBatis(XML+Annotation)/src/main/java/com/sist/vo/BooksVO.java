package com.sist.vo;

import lombok.Getter;
import lombok.Setter;
//jar�� ���� => jar�� �ִ� ��ġ�� �̵�
//java -jar ����.jar�� �ϸ� ��
//�ǹ� => ���� lombok�� ����Ѵ�
@Getter	//���α׷� ������ ���
@Setter // myBatis�� ���
public class BooksVO {
 private String title;
 private String price;
}
