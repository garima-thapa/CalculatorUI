'''
def calculator():
    print("Simple Calculator")
    num1 = float(input("Enter first number: "))
    operator = input("Enter operator (+, -, *, /): ")
    num2 = float(input("Enter second number: "))

    if operator == '+':
        result = num1 + num2
    elif operator == '-':
        result = num1 - num2
    elif operator == '*':
        result = num1 * num2
    elif operator == '/':
        if num2 != 0:
            result = num1 / num2
        else:
            return "Error! Division by zero."
    else:
        return "Invalid operator!"

    return f"Result: {result}"


# Run the calculator
print(calculator())
'''
import tkinter as tk
#functions to handle button clicks
def click_button(value):
    entry.insert(tk.END,str(value))
    '''
    #get current text inside the entry widget
    current=tk.entry.get()
    #clearing
    tk.entry.delete(0,tk.END)
    #inserting the new text
    entry.insert(tk.END,current+str(value))
'''
#function to clear the entry field
def clear_entry():
    entry.delete(0,tk.END) #it will delete everything inside the entry widget

#function to calculate the result when = is pressed
def calculate():
    try:
       # global result #if it shows error make variable global
        #evaluating the expressions inside the box
        result=eval(entry.get())
        #clear the entry field
        entry.delete(0,tk.END)
        #show the result inside the entry widget
        entry.insert(tk.END,str(result))
    except Exception:
        entry.delete(0,tk.END)
        entry.insert(tk.END,"Error")

#creating the calculator UI
root =tk.Tk()
root.title("Calculator")
#creating a widget/box 
entry=tk.Entry(root,width=20,font=("Arial",18),borderwidth=5,relief="ridge")
entry.grid(row=0,column=0,columnspan=4) #it will places it at top spanning 4 columns

#now defining buttons(text,row,column positions)
buttons=[
    ('7', 1, 0), ('8', 1, 1), ('9', 1, 2), ('/', 1, 3),
    ('4', 2, 0), ('5', 2, 1), ('6', 2, 2), ('*', 2, 3),
    ('1', 3, 0), ('2', 3, 1), ('3', 3, 2), ('-', 3, 3),
    ('0', 4, 0), ('.', 4, 1), ('+', 4, 2), ('=', 4, 3),
]

#loop through the button list and create each button
for(text,row,col) in buttons:
    if text == '=':
        btn=tk.Button(root,text=text,width=5,height=2,command=calculate)
    else:
        btn=tk.Button(root,text=text,width=5,height=2,command=lambda t=text: click_button(t))

    #placing the button in the correct row and columns
    btn.grid(row=row,column=col)

#creating a clear button to reset the entry field
clear_btn=tk.Button(root,text="C",width=5,height=2,command=clear_entry)
clear_btn.grid(row=5,column=0,columnspan=4,sticky="we") #span across all columns
root.mainloop()#it will start the main event loop (keeps the window open and responsive)
