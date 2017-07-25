package greedy;

public class gas_station {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		int len = gas.length;
		int gasCopy[] = new int[2 * len];
		int costCopy[] = new int[2 * len];
		int totalGas = 0;
		int useGas = 0;
		for(int i = 0; i < gas.length; i++){
			gasCopy[i] = gas[i];
			gasCopy[len + i] = gas[i];
			costCopy[i] = cost[i];
			costCopy[len + i] = cost[i];
			totalGas += gas[i];
			useGas += cost[i];
		}
		if(totalGas < useGas)
			return -1;
		
		int start = 0;
		totalGas = 0;
		useGas = 0;
		boolean flag = false;
		while(start < len){
			if(flag)
				break;
			flag = false;
	        for(int i = start;i < gasCopy.length; i++){
	        	totalGas += gasCopy[i];
	        	useGas += costCopy[i];
	        	if(totalGas < useGas){
	        		totalGas = 0;
	        		useGas = 0;
	        		start++;	
	        		break;
	        	}	   
	        	if(start + len == i){
	        		flag = true;
	        		break;
	        	}
	        }  
		}
		if(flag)
			return start;
		return -1;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		gas_station g = new gas_station();
		int gas[] = new int[]{4,7,9,10,2,5,8,11};
		int cost[] = new int[]{5,4,2,18,4,4,9,10};
		System.out.println(g.canCompleteCircuit(gas, cost));
	}

}
