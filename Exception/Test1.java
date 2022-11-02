package Exception;

class NameException extends RuntimeException{
    public NameException(String message){
        super(message);
    }
}
class PasswordsException extends RuntimeException{
    public PasswordsException(String message){
        super(message);
    }
}
public class Test1 {
    private static final String name = "bit";
    private static final String password = "123";

    public static void login(String name, String password) throws NameException,PasswordsException{
        if(!Test1.name.equals(name)){
            throw new NameException("用户名错误");
        }
        if(!Test1.password.equals(password)){
            throw new PasswordsException("密码错误");
        }

    }

    public static void main(String[] args) {
        int i = 0;
        while (i<10){
            try {
                if(i<10){
                    throw new Exception();
                }
            }catch (Exception e){
                e.printStackTrace();
                System.out.println("尝试连接网络" + i+"次");
                i++;
            }
        }
        System.out.println("终于正常了");
    }

    public static void main2(String[] args) {
        try {
            throw new Exception("我抛出异常了");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("我执行了");
        }
    }
    public static void main1(String[] args) {
        try{
            login("bit" , "1234");
        }catch (NameException e ){
            System.out.println("用户名错误");
        }catch (PasswordsException e ){
            e.printStackTrace();
            System.out.println("密码错误");
        }finally {
            System.out.println("finally 执行了！");
        }
    }
}
