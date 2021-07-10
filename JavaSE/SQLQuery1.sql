CREATE TABLE cls
	(
		clsId char(2) PRIMARY KEY,
		clsName varchar(10) not null,
		clsAdmin varchar(10),
		clsTime date
	);
	
	CREATE TABLE student
		(
			clsId CHAR(2),
			stuId VARCHAR(10) PRIMARY KEY,
			stuName VARCHAR(10),
			stuSex CHAR(1),
			stuBirthday datetime,
			stuAddress VARCHAR(30),
			stuPhone VARCHAR(20),
			FOREIGN KEY(clsId) REFERENCES cls(clsId)
		);
		
	CREATE TABLE course
		(
			couId CHAR(2) PRIMARY KEY,
			couName VARCHAR(20),
			couKs INT,
			couType VARCHAR(10)
		);
		
	CREATE TABLE xuanke
		(
			xkId INT,
			couId CHAR(2),
			stuId VARCHAR(10),
			couScore INT,
			FOREIGN KEY(couId) REFERENCES course(couId),
			FOREIGN KEY(stuId) REFERENCES student(stuId)
		);
		
	CREATE TABLE teacher
		(
			teaId VARCHAR(10) PRIMARY KEY,
			teaName VARCHAR(10),
			teaSex CHAR(1),
			teaZc VARCHAR(10)
		);
		
	CREATE TABLE paike
		(
			pkId INT,
			teaId VARCHAR(10),
			couId CHAR(2),
			FOREIGN KEY(teaId) REFERENCES teacher(teaId),
			FOREIGN KEY(couId) REFERENCES course(couId)
		)