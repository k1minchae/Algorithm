n = int(input())
def func(base):
    l = len(base)
    temp = []
    for b in base:
        temp.append(' ' * l + b + ' ' * l)
    for b in base:
        temp.append(b + ' ' + b)
    return temp

star = ["  *  ", " * * ", "*****"]

while len(star) != n:
    star = func(star)
for i in star:
    print(i)