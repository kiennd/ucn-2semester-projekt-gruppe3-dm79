/**
 * 
 * @author FaithNielsen
 *
 *Class to control access to chopsticks
 */
public class Waiter {
	private static Chopstick[] m_chopsticks = new Chopstick[5];
	private long m_starttime;
	
	/**
	 * constructor for Waiter class. gets current time, instantiates 5 chopsticks
	 */
	
	public Waiter() {
		m_starttime = System.currentTimeMillis();
		
        for(int i = 0; i < m_chopsticks.length; ++i)
        	m_chopsticks[i]= new Chopstick();
	}
	
	/*
	 * method to get waiter's start time
	 */
	public long getStarttime() {
		return m_starttime;
	}

	
	
    public synchronized void lock(int philosoperNo) throws InterruptedException {

    	int c1 = philosoperNo;
    	int c2 = philosoperNo!=0?philosoperNo-1:m_chopsticks.length-1;
    	
    	while(m_chopsticks[c1].isUsed() || m_chopsticks[c2].isUsed()){
        	System.out.println(System.currentTimeMillis() - m_starttime + " : P" + philosoperNo + " WAIT to get both chopstiks ["+c1+" and "+c2+"]");
    		wait();
  		}
    	
    	m_chopsticks[c1].setUsed(true);
    	m_chopsticks[c2].setUsed(true);
    	
    	System.out.println(System.currentTimeMillis() - m_starttime + " : P" + philosoperNo + " GETS his two chopsticks ["+c1+" and "+c2+"]");
  	}
  		  
  	public synchronized void unlock(int philosoperNo) throws InterruptedException {
    	int c1 = philosoperNo;
    	int c2 = philosoperNo!=0?philosoperNo-1:m_chopsticks.length-1;
    	
    	m_chopsticks[c1].setUsed(false);
    	m_chopsticks[c2].setUsed(false);
    	
  		System.out.println(System.currentTimeMillis() - m_starttime + " : P" + philosoperNo + " FREE his two chopsticks ["+c1+" and "+c2+"]");
  		
  		notify();
  	}    
	
}
