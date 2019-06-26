--유저 인포 테이블
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

--입력 예
insert into userinfom(num,id,password,name,phone,address) values(userinfomseq.nextval,'호롤로','111', '홍길동', '010-3371-1131','광주광역시 광산구 월곡동');

--푸드카테고리 테이블
create table foodcategory(
category_num number not null,
category_name varchar2(100) Primary key
);

create sequence foodcategory_seq;

insert into foodcategory(category_num,category_name) values(foodcategory_seq.nextval,'카테고리 이름');

--음식정보 테이블
create table foodinfo(
foodinfo_num number Primary key,
foodinfo_foodname varchar2(100),
foodinfo_calorie varchar2(100),
c_num number
);

create sequence foodinfo_seq;

--입력 예
insert into foodinfo(foodinfo_num, foodinfo_foodname, foodinfo_calorie, c_num) values(foodinfo_seq.nextval,'음식명', '칼로리', '카테고리 고유 번호');

--운동정보 테이블
create table exerciseinfo(
exerciseinfo_num number not null,
exerciseinfo_name varchar2(100) Primary key,
exerciseinfo_consum varchar2(100) not null
);

create sequence exerciseinfo_seq;

--입력 예
insert into exerciseinfo(exerciseinfo_num, exerciseinfo_name, exerciseinfo_consum) values(exerciseinfo_seq.nextval,'운동명', '칼로리소모량');

--게시판 테이블
create table dtboard(
dtboard_num number not null,
u_id varchar2(100) not null,
dtboard_title varchar2(100) not null,
dtboard_content varchar2(400),
dtboard_inputdate date
);

create sequence dtboard_seq;

--입력 예
insert into dtboard(dtboard_num, u_id, dtboard_title, dtboard_content, dtboard_inputdate) values(dtboard_seq.nextval,'작성자 아이디', '제목','내용',sysdate);

commit;