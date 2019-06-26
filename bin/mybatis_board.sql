--���� ���� ���̺�
create table USERINFOM(
num number not null,
id varchar2(100) Primary key,
password varchar2(100) not null,
name varchar2(40),
phone varchar2(40),
address varchar2(100),
inputdate date default sysdate
);

create sequence userinfom_seq;

--�Է� ��
insert into userinfom(num,id,password,name,phone,address) values(userinfomseq.nextval,'ȣ�ѷ�','111', 'ȫ�浿', '010-3371-1131','���ֱ����� ���걸 ���');

--Ǫ��ī�װ� ���̺�
create table foodcategory(
category_num number not null,
category_name varchar2(100) Primary key
);

create sequence foodcategory_seq;

insert into foodcategory(category_num,category_name) values(foodcategory_seq.nextval,'ī�װ� �̸�');

--�������� ���̺�
create table foodinfo(
foodinfo_num number Primary key,
foodinfo_foodname varchar2(100),
foodinfo_calorie varchar2(100),
c_num number
);

create sequence foodinfo_seq;

--�Է� ��
insert into foodinfo(foodinfo_num, foodinfo_foodname, foodinfo_calorie, c_num) values(foodinfo_seq.nextval,'���ĸ�', 'Į�θ�', 'ī�װ� ���� ��ȣ');

--����� ���̺�
create table exerciseinfo(
exerciseinfo_num number not null,
exerciseinfo_name varchar2(100) Primary key,
exerciseinfo_consum varchar2(100) not null
);

create sequence exerciseinfo_seq;

--�Է� ��
insert into exerciseinfo(exerciseinfo_num, exerciseinfo_name, exerciseinfo_consum) values(exerciseinfo_seq.nextval,'���', 'Į�θ��Ҹ�');

--�Խ��� ���̺�
create table dtboard(
dtboard_num number not null,
u_id varchar2(100) not null,
dtboard_title varchar2(100) not null,
dtboard_content varchar2(400),
dtboard_inputdate date
);

create sequence dtboard_seq;

--�Է� ��
insert into dtboard(dtboard_num, u_id, dtboard_title, dtboard_content, dtboard_inputdate) values(dtboard_seq.nextval,'�ۼ��� ���̵�', '����','����',sysdate);

commit;