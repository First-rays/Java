package realize;

import process.Init;
import process.IprocessContral;

public class Sjf implements IprocessContral {
    @Override
    public void processContral() {
        Init init = new Init();
        init.sort2();
        int flagTime = 0;
        for(int i = 0; i < init.getNumber(); i++){
            if(i == 0){
                int endTime = init.processes[i].getInTime() +
                        init.processes[i].getServiceTime();
                init.processes[i].setEndTime(endTime);
                flagTime = endTime;
            } else if(flagTime >= init.processes[i].getInTime()){
                int endTime = flagTime +
                        init.processes[i].getServiceTime();
                init.processes[i].setEndTime(endTime);
                flagTime = endTime;
            } else {
                int endTime = init.processes[i].getInTime() +
                        init.processes[i].getServiceTime();
                init.processes[i].setEndTime(endTime);
                flagTime = endTime;
            }
            init.processes[i].setReturnTime(init.processes[i].getEndTime() -
                    init.processes[i].getInTime());
            init.processes[i].setPowerTime(init.processes[i].getReturnTime() /
                    init.processes[i].serviceTime);
        }

    }
}
