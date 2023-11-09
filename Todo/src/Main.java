import entities.Task;
import entities.TodoListApp;

import java.util.Scanner;

public class Main{
    public static void main(String[] args){

        TodoListApp todoList = new TodoListApp();
        Scanner scanner = new Scanner(System.in);

        int op = 0;

        while(op != 5){
            System.out.println("===== Menu =====");
            System.out.println("1. Adicionar Tarefa");
            System.out.println("2. Visualizar Tarefas");
            System.out.println("3. Marcar Tarefa como Concluída");
            System.out.println("4. Excluir Tarefa");
            System.out.println("5. Sair");
            System.out.println("=================");
            System.out.print("Escolha uma opção: ");


            op = scanner.nextInt();
            scanner.nextLine();

            switch (op){
                case 1:
                    System.out.println("Digite o título da tarefa");
                    String title = scanner.nextLine();
                    System.out.println("Digite a descrição da tarefa");
                    String description = scanner.nextLine();
                    Task newTask = new Task(title, description, "Pendente");
                    todoList.addTask(newTask);
                    System.out.println("Tarefa adicionada com sucesso!");
                    break;

                case 2:
                    todoList.viewTasks();
                    break;

                case 3:
                    System.out.println("Digite o título da tarefa que será alterada: ");
                    String taskTitle = scanner.nextLine();
                    Task taskToMarkAsDone = todoList.findTaskByTitle(taskTitle);
                    if (taskToMarkAsDone != null) {
                        System.out.print("Digite o novo status da tarefa (ex. 'Concluída'): ");
                        String newStatus = scanner.nextLine();
                        todoList.markTaskAsDone(taskToMarkAsDone, newStatus);
                        System.out.println("Tarefa marcada como concluída!");
                    } else {
                        System.out.println("Tarefa não encontrada.");
                    }
                    break;

                case 4:
                    System.out.print("Digite o título da tarefa a ser excluída: ");
                    String taskTitleToDelete = scanner.nextLine();
                    boolean taskDeleted = todoList.removeTaskByTitle(taskTitleToDelete);
                    if (taskDeleted) {
                        System.out.println("Tarefa excluída com sucesso!");
                    } else {
                        System.out.println("Tarefa não encontrada.");
                    }
                    break;

                case 5:
                    System.out.println("Obrigado por usar o aplicativo To-Do List!");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }
            }
        }

    }