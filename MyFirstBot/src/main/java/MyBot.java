import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class MyBot extends TelegramLongPollingBot {
    @Override
    public void onUpdateReceived(Update update) {
        String command = update.getMessage().getText();

        SendMessage message = new SendMessage();

        if(command.equals("/start")) {
            System.out.println(update.getMessage().getFrom().getFirstName());
            message.setText(update.getMessage().getFrom().getFirstName());
        }

        message.setChatId(String.valueOf(update.getMessage().getChatId()));

        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }



    @Override
    public String getBotUsername() {
        // TODO
        return "NewMyJavaBot";
    }

    @Override
    public String getBotToken() {
        // TODO
        return "5043380645:AAGgN-TfgNo92cgZ1erGE_nhexk5C0VDSFs";
    }
}
