import sys
import time
import subprocess

MIN_N = 1
MAX_N = 200000
MIN_M = 1
MAX_M = 200000
MIN_t = 1
MAX_t = 10000
MIN_T = 1
MAX_T = 2000000000

START = 1
END = 20

class Judge:

    def __init__(self, ext, solution):
        self.ext = ext
        self.solution = solution

        for i in range(START, END + 1):
            start = time.time() * 1000.0
            self.judge(i)
            print(('%d: %dms') % (i, (time.time() * 1000.0 - start)))

    def judge(self, nth):
        self.check_input(nth)
        answer = self.solve(nth)
        self.check_output(nth, answer)

    def check_input(self, nth):
        f = open(str(nth) + '.in', 'r')

        N, M = map(int, f.readline().split())
        assert (MIN_N <= N <= MAX_N), nth
        assert (MIN_M <= M <= MAX_M), nth

        for t in map(int, f.readline().split()):
            assert (MIN_t <= t <= MAX_t), nth

        for i in range(0, M):
            assert (MIN_T <= int(f.readline()) <= MAX_T), nth

        f.close()

    def solve(self, nth):
        command = []
        if (self.ext == 'java'):
            command = ['java', self.solution]
        elif (self.ext == 'c++'):
           command = ['./' + self.solution]
        else:
            sys.exit('invaild args')

        input_file = open(str(nth) + '.in', 'r')
        proc = subprocess.Popen(command, stdin=input_file, stdout=subprocess.PIPE, stderr=subprocess.PIPE)
        stdout, stderr = proc.communicate()

        return stdout.decode().split('\n')

    def check_output(self, nth, answer):
        f = open(str(nth) + '.out', 'r')

        for ans in answer:
            line = f.readline().strip()
            assert (ans == line), str(nth) + ' ' + ans + ' ' + line

        f.close()

if __name__ == '__main__':
    Judge(sys.argv[1], sys.argv[2])
