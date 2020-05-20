package Factory;

import Factory.PCFactory;

/**
 * @author xt
 * @version 1.0
 * @date 2020/4/23 16:51
 */
public class DellFactory implements PCFactory {
    @Override
    public String makeMouse() {
        return null;
    }

    @Override
    public String makeKeyBoard() {
        return null;
    }
}
