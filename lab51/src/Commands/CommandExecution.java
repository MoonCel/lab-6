package Commands;

import Elements.Person;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.TreeSet;
    public class CommandExecution implements Command, Serializable {
        /**
         * Команда которая исполняет все команды
         *
         * @param collection - коллекция
         * @param line - строка котрую вводят с консоли
         * @param command - комманда котрую вводят с консоли
         * @param file - файл в котором храниться коллекция
         * @param time - текущее время
         */

        String message="";
        private String command;
        private TreeSet<Person> collection;
        private String line;
        private String file;
        private LocalDateTime time;
        public CommandExecution(TreeSet<Person> collection, String line, String command, String file, LocalDateTime time) {
            this.collection = collection;
            this.command = command;
            this.line = line;
            this.file = file;
            this.time = time;

        }

        @Override
        public String action(){
            if (line.equals("help")){
                CommandHelp commandHelp = new CommandHelp();
                message= commandHelp.action();

            } else if (line.equals("info")){
                CommandInfo commandInfo = new CommandInfo(collection, time);
                message= commandInfo.action();

            } else if (line.equals("show")){
                CommandShow commandShow = new CommandShow(collection);
                message= commandShow.action();

            } else if (line.equals("CloseServer")){
                CommandExit commandExit = new CommandExit();
                commandExit.action();

            } else if (line.equals("add")){ //TODO
                CommandAdd commandAdd = new CommandAdd(line, collection);
                message= commandAdd.action();


            } else if ((command).equals("update_id")){
                CommandUpdateID commandUpdateID = new CommandUpdateID(line, collection);
                message= commandUpdateID.action();

            } else if ((command).equals("remove_by_id")){
                CommandRemoveByID commandRemoveByID = new CommandRemoveByID(line, collection);
                message= commandRemoveByID.action();

            } else if ((command).equals("filter_contains_name")){
                if (line.split(" ").length >= 2) {
                    CommandFilterContains commandFilterContains = new CommandFilterContains(line.split(" ")[1], collection);
                    message= commandFilterContains.action();
                }
            } else if ((command).equals("add_if_min")){ //TODO
                CommandAddIfMin commandAddIfMin = new CommandAddIfMin(line, collection);
                message= commandAddIfMin.action();

            } else if ((command).equals("add_if_max")){ //TODO
                CommandAddIfMax commandAddIfMax = new CommandAddIfMax(line, collection);
                message= commandAddIfMax.action();

            } else if ((command).equals("remove_greater")){
                CommandRemoveGreater commandRemoveGreater = new CommandRemoveGreater(line, collection);
                message= commandRemoveGreater.action();

            } else if ((line).equals("clear")){
                CommandClear commandClear = new CommandClear(collection);
                message= commandClear.action();

            } else if ((command).equals("GroupCountingByLocation")){
                CommandGroupCountingByLocation CommandGroupCountingByLocation = new CommandGroupCountingByLocation(collection);
                message= CommandGroupCountingByLocation.action();

            } else if ((command).equals("execute_script")) {
                CommandExecuteScript commandExecuteScript = new CommandExecuteScript(collection, line, command, file, time);
                message= commandExecuteScript.action();
            } else {
                message="\nНеизвестная команда";
                message="help : вывести справку по доступным командам\n";
            }


            return message;

        }
    }
