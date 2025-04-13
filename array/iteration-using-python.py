def for_loop(array):
  """
  O(n)
  :param array:
  """
  for i in range(len(array)):
    print(array[i])
  # for i in array:
  #   print(i)

def for_loop_half(array):
  """
  O(n/2)
  :param array:
  """
  for i in range(0, len(array), 2):
    if i + 1 < len(array):
      print(array[i], array[i + 1])
    else:
      print(array[i])

def for_loop_third(array):
  """
  O(n/3)
  :param array:
  """
  for i in range(0, len(array), 3):
    if i + 2 < len(array):
      print(array[i], array[i + 1], array[i + 2])
    elif i + 1 < len(array):
      print(array[i], array[i + 1])
    else:
      print(array[i])

def for_loop_quarter(array):
  """
  O(n/4)
  :param array:
  """
  for i in range(0, len(array), 4):
    pair = array[i: i+4]
    print(pair)

def for_loop_mth(array, m):
  """
  O(n/m)
  :param array:
  """
  for i in range(0, len(array), m):
    pair = array[i: i+m]
    print(pair)

def main():
  array = [1, 2, 3, 4, 5]
  array = [1, 2, 3, 4, 5, 6, 7]
  # for_loop(array)
  # for_loop_half(array); # reduces iteration by half
  # for_loop_third(array); # reduces iteration by 3
  # for_loop_quarter(array); # reduces iteration by 4
  m = 1 # m > 0
  for_loop_mth(array, m); # reduces iteration by m


main()