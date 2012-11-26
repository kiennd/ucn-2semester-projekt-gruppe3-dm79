public class DiningPhilosophersTable {

    //An instant of the waiter who handle the chopsticks
    private final Waiter m_waiter = new Waiter();

    /*Constructor for the main class
    * Creates and starts all the threads*/
    public DiningPhilosophersTable(){

        Thread t1 = new Thread(new Philosopher(0, m_waiter)); 
        Thread t2 = new Thread(new Philosopher(1, m_waiter)); 
        Thread t3 = new Thread(new Philosopher(2, m_waiter));
        Thread t4 = new Thread(new Philosopher(3, m_waiter));
        Thread t5 = new Thread(new Philosopher(4, m_waiter)); 
        
        
		t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        
    }

    public static void main(String[] args){
        new DiningPhilosophersTable();
    }
}