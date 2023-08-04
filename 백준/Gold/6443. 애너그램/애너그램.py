import sys

si = sys.stdin.readline
N = int(si())


def dfs(enegram_dict, answer: list):
    if len(answer) == len(c_list):
        print("".join(answer))
        return

    for enegram in enegram_dict:
        if enegram_dict[enegram]:
            enegram_dict[enegram] -= 1
            answer.append(enegram)
            dfs(enegram_dict, answer)
            enegram_dict[enegram] += 1
            answer.pop()
    return


for i in range(N):
    c_list = list(map(str, si().rstrip()))
    c_list.sort()
    enegram_dict = dict()
    for c in c_list:
        if c in enegram_dict.keys():
            enegram_dict[c] += 1
        else:
            enegram_dict[c] = 1

    dfs(enegram_dict, [])
