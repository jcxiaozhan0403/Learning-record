class Student {
    constructor(name,sex,score){
        this.name = name;
        this.sex = sex;
        this.score = score;
    }
    
    logInfo(){
        console.log(this.name+"" +this.sex+""+this.score);
    }
    
    changeName(newName){
        this.name = newName;
    }
    
    testScore(){
        if(this.score>=60){
            return '及格';
        } else {
            return '不及格';
        }
    }
}

module.exports = Student;