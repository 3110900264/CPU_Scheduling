//进程类
package OSC.E1;

public class process {
    public String PID;
    public int Time;
    public int Rank;

    public process(){}
    public process(String PID,int Time, int Rank){
        this.PID = PID;
        this.Rank = Rank;//rank越小优先级越高
        this.Time = Time;
    }

    public String getPID() {
        return PID;
    }
    public void setPID(String PID) {
        this.PID = PID;
    }
    public int getTime() {
        return Time;
    }
    public void setTime(int time) {
        Time = time;
    }
    public int getRank() {
        return Rank;
    }
    public void setRank(int rank) {
        Rank = rank;
    }

    public void run(process p){
        p.Time -= 1;
        p.Rank += 1;
    }
}
