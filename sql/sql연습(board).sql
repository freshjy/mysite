desc board;

select * from board;
-- 전체 글 보기 --
select b.no, b.title, b.user_no, date_format(b.reg_date, '%Y-%m-%d %H:%i:%s') as reg_date, b.hit, b.group_no, b.oder_no, b.depth, u.name 
from board b, user u
where b.user_no = u.no
order by group_no desc, oder_no asc, reg_date desc;

-- 선택 게시글 보기 --
select no, title, contents, user_no from board where no=10;
-- 선택 후 조회수 증가 --
update board set hit = hit+1 where no=10; 

-- 게시글 등록 --
insert 
	into board	
values(null, '다섯 번째 글', '제곧내', now(), 0, (SELECT IFNULL(MAX(group_no),0)+1 FROM board as group_no) , 1, 1, 1);

-- 게시글 삭제(본인것만 지울수 있음) --
select * from board;
delete from board where  oder_no=1;

-- 게시글 수정(본인것만 수정 가능) --
update board set title = '난 백정엽', contents = '백정엽' where no=25;





