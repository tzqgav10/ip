# Peira User Guide
Peira is a CLI, Personal Assistant Chatbot that helps you to keep track of various things.
Note that the commands are sensitive to spacing, so please follow the format closely.

Here is what happens when you start Peira:
```
    ____________________________________________________________
    Hello! I'm Peira.
    What can I do for you?
    ____________________________________________________________
```
## Save File
At the beginning of the program, if no data file is detected, Peira
will automatically create one on your hard disk.
<br/>

Example:
```
    No existing tasks file found.
    Starting with an empty task list.
```

Otherwise, the list will be saved and updated every time a command that 
modifies it is entered (`todo`, `mark`, `unmark`, `delete`). 

## Adding Todo: `todo`
Adds a todo task to the task list.

Format: `todo [description]`

Example: `todo Sleep`

```
    ____________________________________________________________
    Got it. I've added this task:
      [T][ ] Sleep
    Now you have 1 tasks in the list.
    ____________________________________________________________
```

## Adding Deadlines: `deadline`
Adds a deadline with a description and a due date/time to the task list.
This command is able to parse the deadline if it is given in the format
of `yyyy-M-d HHmm`. Otherwise, it will take the original deadline.

Format: `deadline [description] /by [deadline]`

Example: `deadline Homework /by Monday 2pm`
```
    ____________________________________________________________
    Unable to parse date and time, using original input!
    Got it. I've added this task:
      [D][ ] Homework (by: Monday 2pm)
    Now you have 1 tasks in the list.
    ____________________________________________________________
```
Example: `deadline Homework /by 2025-3-8 1800`
```
    ____________________________________________________________
    Got it. I've added this task:
      [D][ ] Homework (by: 8 Mar 2025, 6pm)
    Now you have 1 tasks in the list.
    ____________________________________________________________
```

## Adding Event: `event`
Adds an event with a description, start and end time/dates to the
task list. Similar to `deadline`, `event` can parse date/time.

Format: `event [description] /from [start date/time] /to [end date/time]`

Example: `event Dinner /from 2pm /to 4pm`

```
    ____________________________________________________________
    Unable to parse date and time, using original input!
    Got it. I've added this task:
      [E][ ] Dinner (from: 2pm, to: 4pm)
    Now you have 1 tasks in the list.
    ____________________________________________________________
```

## Listing Tasks: `list`
Displays the list of tasks in your task list.

Format: `list`

Example:
```
    ____________________________________________________________
    Here are the tasks in your list:
    1.[E][ ] Dinner (from: 2pm, to: 4pm)
    2.[T][ ] Homework
    3.[D][ ] Sleep (by: now)
    ____________________________________________________________
```

## Finding Tasks: `find`
Finds tasks whose description are associated with the desired keyword.

Format: `find [keyword]`

Example: `find Nothing`
```
    ____________________________________________________________
    There are no matching tasks in your list!
    ____________________________________________________________
```
Example: `find sleep`
```
    ____________________________________________________________
    Here are the matching tasks in your list:
    1.[D][ ] Sleep (by: now)
    ____________________________________________________________
```

## Marking Tasks: `mark`
Marks the task of chosen index from the list of tasks as completed.

Format: `mark [task index]`

Example: `mark 2`
```
    ____________________________________________________________
    Nice! I've marked this task as done:
      [T][X] Homework
    ____________________________________________________________
```

## Unmarking Tasks: `unmark`
Unmarks the task of chosen index from the list of tasks as incomplete.

Format: `unmark [task index]`

Example: `unmark 2`
```
    ____________________________________________________________
    OK, I've marked this task as undone:
      [T][ ] Homework
    ____________________________________________________________
```

## Deleting Tasks: `delete`
Deletes the task of chosen index from the list of tasks.

Format: `delete [task index]`

Example: `delete 2`
```
    ____________________________________________________________
    Okay, I have managed to delete this task:
      [T][ ] Homework
    Now you have 2 tasks in the list.
    ____________________________________________________________
```

## Exiting the Chat: `bye`
Ends the chat with Peira.

Format: `bye`

Example:
```
    ____________________________________________________________
    Bye. Hope to see you again soon!
    ____________________________________________________________

```