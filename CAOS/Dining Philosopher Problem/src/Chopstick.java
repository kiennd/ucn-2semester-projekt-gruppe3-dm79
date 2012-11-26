
public class Chopstick {

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