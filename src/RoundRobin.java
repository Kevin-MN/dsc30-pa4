/*
 * NAME: Kevin Morales-Nguyen
 * PID: A17186624
 */

/**
 * This class utilizes dll's to handle tasks that need to e processed
 *
 * @author Kevin Morales-Nguyen
 * @since 10/26/21
 */
public class RoundRobin {

    /* constants */
    private static final String TASK_HANDLED = "All tasks are already handled.";
    private static final int DEFAULT_QUANTUM = 4;

    /* instance variables */
    private DoublyLinkedList<Task> waitlist, finished;
    private int quantum, burstTime, waitTime;

    /**
     * This is the single param constructor that has deafult
     * quantum of 4
     * @param toHandle an array of tasks
     */
    public RoundRobin(Task[] toHandle) {
       this(DEFAULT_QUANTUM, toHandle);
    }

    /**
     * This is the two parameter constructor that allows for a
     * quantum to be set
     * @param quantum time allotted for tasks to be comppleted
     * @param toHandle an array of tasks
     * @throws IllegalArgumentException if quantum less than 1,
     * toHandle array is null or no tasks in toHandle array
     */
    public RoundRobin(int quantum, Task[] toHandle) {
        if(quantum < 1){
            throw new IllegalArgumentException();
        }

        if(toHandle == null || toHandle.length == 0){
            throw new IllegalArgumentException();
        }

        this.quantum = quantum;
        this.burstTime = 0;
        this.waitTime = 0;
        this.finished = new DoublyLinkedList<Task>();
        this.waitlist = new DoublyLinkedList<Task>();

        for(int i = 0; i < toHandle.length;i++){
            this.waitlist.add(toHandle[i]);
        }
    }

    /**
     * This method process all of the tasks in the waitlist dll,
     * it works in time frames of quantum to allot time for tasks to be done
     * @return a formated string that prints the order of tasks completed in order
     * according to time needed to finish the task, also contains information
     * about total burst and wait time
     */
    public String handleAllTasks() {

        if (this.waitlist.isEmpty()) {
            return TASK_HANDLED;
        }


        Task process_task = waitlist.remove(0); // grab the first task
        int count = 0;

        while (!waitlist.isEmpty()) {

            if (count < this.quantum && process_task.handleTask()) {
                // within quantum and task was handled
                this.burstTime++; // increment burst
                //increment wait by the number of tasks still in the list
                this.waitTime += this.waitlist.size();
                count++; // increment quantum counter
            } else if (count == quantum) { // need to move onto next task
                this.waitlist.add(process_task); // add task back into the dll
                process_task = this.waitlist.remove(0); // grab next task
                count = 0; // reset quantum timer
            } else { // quantum is under max and no task to complete -> move on to next task
                this.finished.add(process_task); // add current task to finished
                process_task = this.waitlist.remove(0); // grab next task
                count = 0;
            }

            //make sure to check the task is completed or not, if yes move to next task
            if (process_task.isFinished()) {
                this.finished.add(process_task);// task is completed to add to finish
                process_task = waitlist.remove(0); // get next task
                count = 0;
            }
        }

            // waitlist will be empty but process task will hold the last task,
            // so there are no other tasks on the waitlist
            while (process_task.handleTask()) { // process final task until done
                this.burstTime++;
            }
            this.finished.add(process_task); // add last task to finished

            //create formated string based on finised dll
            String completed_tasks = "All tasks are handled within " + this.burstTime +
                    " units of" + " burst time and " + this.waitTime +
                    " units of wait time." +
                    " The tasks are " + "finished in this order:\n";

            for (int i = 0; i < this.finished.size() - 1; i++) {
                completed_tasks = completed_tasks.concat(this.finished.get(i).toString()
                        + " -> ");
            }

            //add last task from finished without " -> "
            completed_tasks = completed_tasks.concat(this.finished
                    .get(this.finished.size() - 1).toString());

            return completed_tasks;
    }


    /**
     * Main method for testing.
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        Task[] test1 = {new Task("A", 3), new Task("B", 4),
                        new Task("C", 4), new Task("D", 12),
                        new Task("E", 6), new Task("F", 3)};
        RoundRobin rr1 = new RoundRobin(3, test1);     // Quantum: 3, ToHandle: test1
        System.out.println(rr1.handleAllTasks());   // Burst: 32, Wait: 86, Order: AFBCED
        System.out.println();
        System.out.println(rr1.handleAllTasks());   // TASK_HANDLED
        System.out.println();

        Task[] test2 = {new Task("A", 9), new Task("B", 8),
                        new Task("C", 6), new Task("D", 4),
                        new Task("E", 4), new Task("F", 3)};
        RoundRobin rr2 = new RoundRobin(test2);  // Quantum: 4, ToHandle: test2
        System.out.println(rr2.handleAllTasks());   // Burst: 34, Wait: 123, Order: DEFBCA
        System.out.println();
        System.out.println(rr2.handleAllTasks());   // TASK_HANDLED
        System.out.println();

        Task[] test3 = {new Task("A", 7), new Task("B", 5),
                        new Task("C", 3), new Task("D", 1),
                        new Task("E", 2), new Task("F", 4),
                        new Task("G", 6), new Task("H", 8)};
        RoundRobin rr3 = new RoundRobin(3, test3);     // Quantum: 3, ToHandle: test3
        System.out.println(rr3.handleAllTasks());   // Burst: 36, Wait: 148, Order: CDEBFGAH
        System.out.println();
        System.out.println(rr3.handleAllTasks());   // TASK_HANDLED
        System.out.println();
    }
}