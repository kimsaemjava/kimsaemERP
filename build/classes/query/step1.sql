#�Խ��� ���̺�
drop table board CASCADE CONSTRAINTS;
create table board(
	boardno varchar2(10) primary key,
	boardctg varchar2(20),
	id varchar2(20),
	boarddate date,
	boardtitle varchar2(100),
	boardtxt varchar2(1000)
)
create sequence board_seq;
select * from board;


#�μ� ���̺�
drop table dept CASCADE CONSTRAINTS;
create table dept(
	deptno varchar2(15) primary key,
	deptname varchar2(30),
	deptStartDay date,
	deptEndDay date,
	deptlevel varchar2(5),
	deptstep varchar2(5),
	deptuppercode varchar2(15),
	job_category varchar2(15),
	mgr_id varchar2(15),
	deptaddr varchar2(50),
	depttel varchar2(15)
)
#�λ� ���̺�
drop table member CASCADE CONSTRAINTS;
create table member(
	id varchar2(20) primary key,
	pass varchar2(20),
	name varchar2(15),
	ssn varchar2(15),
	birthday date,
	marry char(1),
	gender char(1),
	position varchar2(15),
	duty varchar2(15),
	classes varchar2(15),
	startday date,
	endday date,
	deptno varchar2(15),
	curstate varchar2(10),
	zipcode varchar2(10),
	addr varchar2(80),
	detailaddr varchar2(50),
	phonehome varchar2(15),
	phoneco varchar2(15),
	phonecell varchar2(15),
	email varchar2(50),
	profile_photo varchar2(50)
)

#�������̺�
drop table job CASCADE CONSTRAINTS;
create table job(
	job_id varchar2(10) primary key,
	job_name varchar2(15),
	job_category varchar2(15),
	menupath varchar2(50)
)

#��������
alter table member
add constraint member_fk foreign key(deptno) references dept(deptno)


alter table dept
add constraint dept_fk foreign key(mgr_id) references member(id)

alter table dept
add constraint job_fk foreign key(job_category) references job(job_id)

#������
insert into job values('j001','����','��������','/menu/sales_menu.jsp');
insert into job values('j002','�λ�','�λ����','/menu/insa_menu.jsp');
insert into job values('j003','����','�������','/menu/it_menu.jsp');
insert into job values('j004','�濵����','�濵����','/menu/manage_menu.jsp');
insert into job values('j005','�繫','�繫����','/menu/jaemu_menu.jsp');

insert into dept values('d001','�λ���','1999/9/27',null,'2','1','dg001','j002','9401023jang','����� ���ʱ� kitri����7��','02-225-1111');
insert into dept values('d002','�繫��','1999/9/27',null,'2','1','dg001','j005','9401023jang','����� ���ʱ� kitri����7��','02-225-1122');
insert into dept values('d003','������','1999/9/27',null,'2','1','dg003','j003','9401023jang','����� ���ʱ� kitri����6��','02-225-1133');
insert into dept values('d0031','��������','1999/9/27',null,'3','1','d003','j003','9401023jang','����� ���ʱ� kitri����6��','02-225-1121');
insert into dept values('d0032','Ajax��','1999/9/27',null,'3','2','d003','j003','9401023jang','����� ���ʱ� kitri����1��','02-225-1131');
insert into dept values('d004','��������','1999/9/27',null,'2','1','dg001','j003','9401023jang','����� ���ʱ� kitri����1��','02-225-1144');
insert into dept values('d005','�ý���������','1999/9/27',null,'2','1','dg001','j003','9401023jang','����� ���ʱ� kitri����2��','02-225-1155');
insert into dept values('d006','�ѹ���','1999/9/27',null,'2','1','dg001','j004','9401023jang','����� ���ʱ� kitri����3��','02-225-1166');
insert into dept values('dg001','�濵��������','1999/9/27',null,'1','1',null,'j004','9401023jang','����� ���ʱ� kitri����4��','02-225-1177');
insert into dept values('dg002','��������','1999/9/27',null,'1','1',null,'j001','9401023jang','����� ���ʱ� kitri����5��','02-225-1188');
insert into dept values('dg003','IT��������','1999/9/27',null,'1','1',null,'j003','9401023jang','����� ���ʱ� kitri����6��','02-225-1199');
insert into dept values('d007','������','1999/9/27',null,'2','1','dg001','j004','9401023jang','����� ���ʱ� kitri����6��','02-225-1100');
insert into dept values('d008','��ȹ��','1999/9/27',null,'2','1','dg001','j004','9401023jang','����� ���ʱ� kitri����5��','02-225-1102');
insert into dept values('d009','����1��','1999/9/27',null,'2','1','dg001','j001','9401023jang','����� ���ʱ� kitri����8��','02-225-1222');
insert into dept values('d010','�����������','1999/9/27',null,'2','1','dg001','j001','9401023jang','����� ���ʱ� kitri����9��','02-225-13331');
insert into dept values('d011','����2��','1999/9/27',null,'2','1','dg001','j001','9401023jang','����� ���ʱ� kitri����10��','02-225-1444');
insert into dept values('d012','�����ý�','1999/9/27',null,'2','1','dg001','j004','9401023jang','����� ���ʱ� kitri����10��','02-225-1555');

insert into member values('9401023jang','1234','�嵿��','731111-1111111','1973/11/11','1','0','����','����','3��20ȣ��','1999/10/01',null,'d001','����','222-222','����� ��õ��','��������','02-858-1111','02-225-1111','010-111-2222','jang@naver.com','jang.jpg');
insert into member values('0111022kim','1234','�����','800521-1111111','1980/09/01','1','0','����','����','4��20ȣ��','2007/02/27',null,'d002','����','222-222','����� ��õ��','��������','02-858-1111','02-225-1111','010-111-3333','kbr@naver.com','kbr.jpg');
insert into member values('92115kim','1234','�輭��','901012-1111111','1990/11/11','1','0','����','����','4��20ȣ��','2010/10/01',null,'d003','����','222-222','����� ��õ��','��������','02-858-1111','02-225-1111','010-111-4444','jang@naver.com','jang.jpg');

insert into member values('9401023jang','�嵿��','731111-1111111','1973/11/11','1','0','����','����','3��20ȣ��','1999/10/01',null,'d001','����','222-222','����� ��õ��','��������','02-858-1111','010-111-5555','jang@naver.com','jang.jpg');
insert into member values('9401023jang','�嵿��','731111-1111111','1973/11/11','1','0','����','����','3��20ȣ��','1999/10/01',null,'d001','����','222-222','����� ��õ��','��������','02-858-1111','010-111-6666','jang@naver.com','jang.jpg');
insert into member values('9401023jang','�嵿��','731111-1111111','1973/11/11','1','0','����','����','3��20ȣ��','1999/10/01',null,'d001','����','222-222','����� ��õ��','��������','02-858-1111','010-222-7777','jang@naver.com','jang.jpg');
insert into member values('9401023jang','�嵿��','731111-1111111','1973/11/11','1','0','����','����','3��20ȣ��','1999/10/01',null,'d001','����','222-222','����� ��õ��','��������','02-858-1111','010-222-2222','jang@naver.com','jang.jpg');
insert into member values('9401023jang','�嵿��','731111-1111111','1973/11/11','1','0','����','����','3��20ȣ��','1999/10/01',null,'d001','����','222-222','����� ��õ��','��������','02-858-1111','010-222-8888','jang@naver.com','jang.jpg');
insert into member values('9401023jang','�嵿��','731111-1111111','1973/11/11','1','0','����','����','3��20ȣ��','1999/10/01',null,'d001','����','222-222','����� ��õ��','��������','02-858-1111','010-333-9999','jang@naver.com','jang.jpg');
insert into member values('9401023jang','�嵿��','731111-1111111','1973/11/11','1','0','����','����','3��20ȣ��','1999/10/01',null,'d001','����','222-222','����� ��õ��','��������','02-858-1111','010-444-5555','jang@naver.com','jang.jpg');
insert into member values('9401023jang','�嵿��','731111-1111111','1973/11/11','1','0','����','����','3��20ȣ��','1999/10/01',null,'d001','����','222-222','����� ��õ��','��������','02-858-1111','010-555-6666','jang@naver.com','jang.jpg');
insert into member values('9401023jang','�嵿��','731111-1111111','1973/11/11','1','0','����','����','3��20ȣ��','1999/10/01',null,'d001','����','222-222','����� ��õ��','��������','02-858-1111','010-777-4444','jang@naver.com','jang.jpg');
insert into member values('9401023jang','�嵿��','731111-1111111','1973/11/11','1','0','����','����','3��20ȣ��','1999/10/01',null,'d001','����','222-222','����� ��õ��','��������','02-858-1111','010-2323-2222','jang@naver.com','jang.jpg');
insert into member values('9401023jang','�嵿��','731111-1111111','1973/11/11','1','0','����','����','3��20ȣ��','1999/10/01',null,'d001','����','222-222','����� ��õ��','��������','02-858-1111','010-4545-2546','jang@naver.com','jang.jpg');
insert into member values('9401023jang','�嵿��','731111-1111111','1973/11/11','1','0','����','����','3��20ȣ��','1999/10/01',null,'d001','����','222-222','����� ��õ��','��������','02-858-1111','010-7777-4564','jang@naver.com','jang.jpg');
insert into member values('9401023jang','�嵿��','731111-1111111','1973/11/11','1','0','����','����','3��20ȣ��','1999/10/01',null,'d001','����','222-222','����� ��õ��','��������','02-858-1111','010-7878-4556','jang@naver.com','jang.jpg');
insert into member values('9401023jang','�嵿��','731111-1111111','1973/11/11','1','0','����','����','3��20ȣ��','1999/10/01',null,'d001','����','222-222','����� ��õ��','��������','02-858-1111','010-1414-8907','jang@naver.com','jang.jpg');


select * from job;
select * from dept;
select * from member;

1. �α��ν� �ʿ��� �����͸� �����ؼ� ��������
=> member�� �⺻������, job���̺��� job_category, menupath
=> �α��� �����ϸ� content.jsp�� ���ڿ��� job_category�����κ���
   �α��� ���� �Ŀ� �� job_id���� ���ǵ� menupath���� view������ ������ �����ϱ�
   �α��� ���� �Ŀ� profile_photo�� ��ϵ� �̹����� ����
   �÷��� �޶������Ƿ� LoginServlet, LoginDAOImpl����, LoginDTO�� ����


