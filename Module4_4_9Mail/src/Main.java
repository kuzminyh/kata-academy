import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static final String AUSTIN_POWERS = "Austin Powers";
Files
    public static final String WEAPONS = "weapons";

    public static final String BANNED_SUBSTANCE = "banned substance";

    public static void main(String[] args) {
//        Logger logger = Logger.getLogger(Main.class.getName());
//        Inspector inspector = new Inspector();
//        Spy spy = new Spy(logger);
//        Thief thief = new Thief(10000);
//        UntrustworthyMailWorker worker = new UntrustworthyMailWorker(new MailService[]{spy, thief, inspector});
//        AbstractSendable[] correspondence = {
//                new MailMessage("Oxxxymiron", "Гнойный", " Я здесь чисто по фану, поглумиться над слабым\n" +
//                        "Ты же вылез из мамы под мой дисс на Бабана...."),
//                new MailMessage("Гнойный", "Oxxxymiron", "....Что? Так болел за Россию, что на нервах терял ганглии.\n" +
//                        "Но когда тут проходили митинги, где ты сидел? В Англии!...."),
//                new MailMessage("Жириновский", AUSTIN_POWERS, "Бери пацанов, и несите меня к воде."),
//                new MailMessage(AUSTIN_POWERS, "Пацаны", "Го, потаскаем Вольфовича как Клеопатру"),
//                new MailPackage("берег", "море", new Package("ВВЖ", 32)),
//                new MailMessage("NASA", AUSTIN_POWERS, "Найди в России ракетные двигатели и лунные stones"),
//                new MailPackage(AUSTIN_POWERS, "NASA", new Package("ракетный двигатель ", 2500000)),
//                new MailPackage(AUSTIN_POWERS, "NASA", new Package("stones ", 1000)),
//                new MailPackage("Китай", "КНДР", new Package("banned substance ", 10000)),
//                new MailPackage(AUSTIN_POWERS, "Жопа запрещенная группировка", new Package("tiny bomb", 9000)),
//                new MailMessage(AUSTIN_POWERS, "Психиатр", "Помогите"),
//        };
//
//        for (AbstractSendable p : correspondence) {
//            try {
//                print("До:  ", p);
//                Sendable sendable = worker.processMail(p);
//                print("После:  ", sendable);
//            } catch (StolenPackageException | IllegalPackageException e) {
//                logger.log(Level.WARNING, "из: " + p.getFrom() + " куда: " + p.getTo() + " Содержимое: "
//                        + (p instanceof MailMessage ? ((MailMessage) p).getMessage() : ((MailPackage) p).getContent().getContent()
//                        + " Цена=" + ((MailPackage) p).getContent().getPrice()) + " Exceptions: " + e);
//            }
//        }
        MailService spy = new Spy(Logger.getLogger(Class.class.getName()));
        MailService thief = new Thief(17);
        MailService inspector = new Inspector();
        MailService[] msArray = {spy, thief, inspector};
        MailMessage mail1 = new MailMessage("Romeo", "Juliet", "I love you!");
        MailMessage mail2 = new MailMessage("Austin Powers", "James Bond", "Big secret!");
        MailPackage mail3 = new MailPackage("Romeo", "Juliet", new Package("Flowers", 15));
        MailPackage mail4 = new MailPackage("Romeo", "Juliet", new Package("Flowers", 25));
        MailPackage mail5 = new MailPackage("Austin Powers", "James Bond", new Package("weapons", 5));

        UntrustworthyMailWorker umw = new UntrustworthyMailWorker(msArray);
        try {
            umw.processMail(mail1);
        } catch (RuntimeException re) {
            System.out.println(re.getMessage());
        }
        try {
            umw.processMail(mail2);
        } catch (RuntimeException re) {
            System.out.println(re.getMessage());
        }
        try {
            umw.processMail(mail3);
        } catch (RuntimeException re) {
            System.out.println(re.getMessage());
        }
        try {
            umw.processMail(mail4);
        } catch (RuntimeException re) {
            System.out.println(re.getMessage());
        }
        try {
            umw.processMail(mail5);
        } catch (RuntimeException re) {
            System.out.println(re.getMessage());
        }
        System.out.println("Thief have stolen $" + ((Thief) thief).getStolenValue() + "!");

    }

    public static void print(String prefix, Sendable p) {
        System.out.println(prefix + "из: " + p.getFrom() + " куда: " + p.getTo() + " Содержимое: "
                + (p instanceof MailMessage ? ((MailMessage) p).getMessage() : ((MailPackage) p).getContent().getContent()
                + " Цена=" + ((MailPackage) p).getContent().getPrice()));
    }

    /*
 Интерфейс: сущность, которую можно отправить по почте.
 У такой сущности можно получить от кого и кому направляется письмо.
 */
    public static interface Sendable {
        String getFrom();

        String getTo();
    }

    /*
Абстрактный класс,который позволяет абстрагировать логику хранения
источника и получателя письма в соответствующих полях класса.
*/
    public static abstract class AbstractSendable implements Sendable {

        protected final String from;
        protected final String to;

        public AbstractSendable(String from, String to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public String getFrom() {
            return from;
        }

        @Override
        public String getTo() {
            return to;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            AbstractSendable that = (AbstractSendable) o;

            if (!from.equals(that.from)) return false;
            if (!to.equals(that.to)) return false;

            return true;
        }

    }

    /*
Письмо, у которого есть текст, который можно получить с помощью метода `getMessage`
*/
    public static class MailMessage extends AbstractSendable {

        private final String message;

        public MailMessage(String from, String to, String message) {
            super(from, to);
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;

            MailMessage that = (MailMessage) o;

            if (message != null ? !message.equals(that.message) : that.message != null) return false;

            return true;
        }

    }

    /*
Посылка, содержимое которой можно получить с помощью метода `getContent`
*/
    public static class MailPackage extends AbstractSendable {
        private final Package content;

        public MailPackage(String from, String to, Package content) {
            super(from, to);
            this.content = content;
        }

        public Package getContent() {
            return content;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;

            MailPackage that = (MailPackage) o;

            if (!content.equals(that.content)) return false;

            return true;
        }

    }

    /*
    Класс, который задает посылку. У посылки есть текстовое описание содержимого и целочисленная ценность.
    */
    public static class Package {
        private final String content;
        private final int price;

        public Package(String content, int price) {
            this.content = content;
            this.price = price;
        }

        public String getContent() {
            return content;
        }

        public int getPrice() {
            return price;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Package aPackage = (Package) o;

            if (price != aPackage.price) return false;
            if (!content.equals(aPackage.content)) return false;

            return true;
        }
    }

    /*
    Интерфейс, который задает класс, который может каким-либо образом обработать почтовый объект.
    */
    public static interface MailService {
        Sendable processMail(Sendable mail);
    }

    /*
    Класс, в котором скрыта логика настоящей почты
    */
    public static class RealMailService implements MailService {

        @Override
        public Sendable processMail(Sendable mail) {
            // Здесь описан код настоящей системы отправки почты.
            return mail;
        }
    }

    // ------======== Thief =======---------
    public static class Thief implements MailService {
        private int minPrice = 0;

        private int stolenPrice = 0;

        public Thief(int minPrice) {

            this.minPrice = minPrice;

        }

        public int getStolenValue() {

            return this.stolenPrice;

        }

        @Override

        public Sendable processMail(Sendable mail) {

            if (mail.getClass() == MailPackage.class) {

                Package pac = ((MailPackage) mail).getContent();

                if (pac.getPrice() >= minPrice) {

                    stolenPrice += pac.getPrice();

                    mail = new MailPackage(mail.getFrom(), mail.getTo(), new Package("stones instead of " + pac.getContent(), 0));

                }

            }

            return mail;

        }

    }

    public static class IllegalPackageException extends RuntimeException {

    }

    public static class StolenPackageException extends RuntimeException {
    }

    public static class Inspector implements MailService {

        @Override

        public Sendable processMail(Sendable mail) {
            if (mail instanceof MailPackage) {
//                String mes = ((MailPackage) mail).getContent().toString();
                Package pac = ((MailPackage) mail).getContent();
                String content = pac.getContent();


                        //String.valueOf(((MailPackage) mail).getContent());
                        //.toString();
                System.out.println(content);
                if (content.contains("stones")) {
                    throw new StolenPackageException();
                }
                if (content.contains(WEAPONS) || content.contains(BANNED_SUBSTANCE)) {
                    throw new IllegalPackageException();
                }
            }
            return mail;


        }

    }

    public static class Spy implements MailService {

        private Logger logger;

        public Spy(Logger logger) {

            logger = logger;

        }

        @Override

        public Sendable processMail(Sendable mail) {

            if (mail.getClass() == MailMessage.class) {

                MailMessage mailMessage = (MailMessage) mail;

                String from = mailMessage.getFrom();

                String to = mailMessage.getTo();

                if (from.equals(AUSTIN_POWERS) || to.equals(AUSTIN_POWERS)) {

                    logger.warning("Detected target mail correspondence: from " + from + " to " + to + " \"" + mailMessage.getMessage() + "\"");

                } else {

                    logger.info("Usual correspondence: from " + from + " to " + to + "");

                }

            }

            return mail;

        }

    }

    public static class UntrustworthyMailWorker implements MailService {

        public RealMailService realMailService;

        public  MailService[] mailServices;

        public UntrustworthyMailWorker(MailService[] services) {

            this.mailServices = services;
            this.realMailService = new RealMailService();

        }

        public RealMailService getRealMailService() {

            return realMailService;

        }

        @Override

        public Sendable processMail(Sendable mail) {

            Sendable buff = mailServices[0].processMail(mail);
            for (int i = 1; i < mailServices.length; i++) {
                buff = mailServices[i].processMail(buff);
            }
            return getRealMailService().processMail(buff);

        }

    }

}