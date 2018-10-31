def calculate(A, oper, B):
    if oper == '*':
        return A * B
    elif oper == '/':
        return A // B
    elif oper == '+':
        return A + B
    elif oper == '-':
        return A - B

line = input().split()
K1 = int(line[0])
O1 = line[1]
K2 = int(line[2])
O2 = line[3]
K3 = int(line[4])

first = calculate(calculate(K1, O1, K2), O2, K3)
second = calculate(K1, O1, calculate(K2, O2, K3))
print(min([first, second]))
print(max([first, second]))
