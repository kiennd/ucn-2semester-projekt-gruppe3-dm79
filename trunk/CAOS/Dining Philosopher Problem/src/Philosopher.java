import java.util.Random;


public class Philosopher extends Thread{

    private static final int MAX_EATING_TIME = 200;
    private static final int MAX_THINKING_TIME = 100;
    private final Random randomise = new Random();
    
    private long m_starttime;
    private final Waiter m_waiter; 
    private final int m_number;
    private State m_state;

    /* Enumeration class that holds 
    * information about the possible 
    * Philosopher's states 
    */
    public enum State {
        EATING, THINKING
    }

    /*
    * Main constructor for the Philosopher class
    * @param waiter has the access to the chopsticks
    * @param the philosophers number
    * When we start a waiter, we get the waiter's start time
    * and use it for monitoring the philosopher's start time too.
    */
    public Philosopher(int number, Waiter waiter) {
        this.m_waiter = waiter; 
        this.m_number = number;
        
        this.m_starttime = m_waiter.getStarttime();
        System.out.println("P" + number +" started.");
    }

    /*
     * The waiter gives the philosopher both Chopsticks at the same time or none of them.
     * Philosopher should inform the waiter when he has finished eating, so that the waiter can take both chopstiks back. 
     * Based on the philosopher's Id, we lock the resources he has access to i.e. his immediate left and right chopsticks.
    */
    private void eat() throws InterruptedException {

    	m_waiter.lock(m_number);
    	
        int eattime = randomise.nextInt(MAX_EATING_TIME);
        this.setPhilosopherState(Philosopher.State.EATING, eattime);
        Thread.sleep(eattime);
        
        m_waiter.unlock(m_number);
        
        think();
    }

    /*
    * This method only changes the state 
    * of the Philosopher to Thinking
    */
    private void think() throws InterruptedException{
        int thinktime = randomise.nextInt(MAX_THINKING_TIME);
        this.setPhilosopherState(Philosopher.State.THINKING, thinktime);
        Thread.sleep(thinktime);
    }

    /*
    * Set the current state of the Philosopher
    */
    private void setPhilosopherState(State state, int sleeping){
        this.m_state = state;
        
        System.out.println(System.currentTimeMillis() - m_starttime +" : P"+ m_number +" will be "+ state + " for " + sleeping + " miliseconds;");
    }

    /*
    * Get the current state of the Philosopher
    */
    public State getPhilosopherState(){
        return m_state;
    }

    /*
    * The method is invoked with the start of the thread
    * and runs the eat function for 10 times
    */
    public void run(){
        for(int i=0; i<10; ++i){
            try {
                eat();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(System.currentTimeMillis() - m_starttime +" : P"+ m_number + " succesfully finished.");
    }
 

}
