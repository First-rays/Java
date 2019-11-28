package process;

public class Process {
    public String processName;   //进程名
    public int inTime;           //进入时间
    public int serviceTime;     //服务时间
    public int grade;           //优先级
    public int time;            //时间片
    public int returnTime;     //周转时间
    public double powerTime;      //带权周转时间
    public static Process[] processes = new Process[5];
    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public int getInTime() {
        return inTime;
    }

    public void setInTime(int inTime) {
        this.inTime = inTime;
    }

    public int getServiceTime() {
        return serviceTime;
    }

    public void setServiceTime(int serviceTime) {
        this.serviceTime = serviceTime;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
