package Class.Factory;

import Class.Branch.FastFoodBranch;
import Interface.FastFoodBranchAbstractFactory;

public class FastFoodBranchFactory {
    public static FastFoodBranch getBranch(FastFoodBranchAbstractFactory factory){
        return factory.createNewBranch();
    }
}
