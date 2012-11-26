
public class Chopstick {

    /**
     * if chopstick is in use set variable to true, if it is not in use set variable to false
     */
	private boolean m_isUsed = false;

    /*
    * @return the current state of the chopstick
    */
    public boolean isUsed(){
        return m_isUsed; 
    }

    /*
    * @param usedFlag the new state of the chopstick
    */
    public void setUsed(boolean usedFlag){
    	m_isUsed = usedFlag;
    }
}