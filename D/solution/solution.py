def to_binary(value, size):
    binary = [ 0, 0, 0, 0 ]
    
    for i in range(3, -1, -1):
        binary[i] = value % 2
        value //= 2

    ret = ''
    for i in range(4 - size, 4):
        ret += str(binary[i])

    return ret

def convert(op, rD, rA, rB):
    code = ''

    if op == 'ADD':
        code += '00000'
    elif op == 'ADDC':
        code += '00001'
    elif op == 'SUB':
        code += '00010'
    elif op == 'SUBC':
        code += '00011'
    elif op == 'MOV':
        code += '00100'
    elif op == 'MOVC':
        code += '00101'
    elif op == 'AND':
        code += '00110'
    elif op == 'ANDC':
        code += '00111'
    elif op == 'OR':
        code += '01000'
    elif op == 'ORC':
        code += '01001'
    elif op == 'NOT':
        code += '01010'
    elif op == 'MULT':
        code += '01100'
    elif op == 'MULTC':
        code += '01101'
    elif op == 'LSFTL':
        code += '01110'
    elif op == 'LSFTLC':
        code += '01111'
    elif op == 'LSFTR':
        code += '10000'
    elif op == 'LSFTRC':
        code += '10001'
    elif op == 'ASFTR':
        code += '10010'
    elif op == 'ASFTRC':
        code += '10011'
    elif op == 'RL':
        code += '10100'
    elif op == 'RLC':
        code += '10101'
    elif op == 'RR':
        code += '10110'
    elif op == 'RRC':
        code += '10111'

    code += '0' # 5
    code += to_binary(rD, 3) # 6-8
    code += to_binary(rA, 3) # 9-11
    
    if (op[-1] == 'C'):
        code += to_binary(rB, 4) # 12-15
    else:
        code += to_binary(rB, 3) # 12-14
        code += '0' # 15

    return code

    
N = int(input())
for i in range(N):
    line = input().split()
    op = line[0]
    rD = int(line[1])
    rA = int(line[2])
    rB = int(line[3])

    code = convert(op, rD, rA, rB)
    print(code)
