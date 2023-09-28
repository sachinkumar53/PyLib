import numpy as np


def demo():
    return 1234567890


# Function 1: numpy.array
def create_array():
    """
    Creates a NumPy array.

    Input: None
    Output: numpy.ndarray
    """
    return np.array([1, 2, 3, 4, 5])


# Function 2: numpy.zeros
def create_zeros_array(dimensions):
    return np.zeros(dimensions)


# Function 3: numpy.ones
def create_ones_array(dimensions):
    return np.ones(dimensions)


# Function 4: numpy.arange
def create_arange_array(start, stop, step):
    return np.arange(start, stop, step)


# Function 5: numpy.linspace
def create_linspace_array(start, stop, space):
    return np.linspace(start, stop, space)


# Function 6: numpy.reshape
def reshape_array(arr, m, n):
    return np.reshape(arr, (m, n)).tolist()


# Function 7: numpy.transpose
def transpose_array(arr):
    return np.transpose(arr).tolist()


# Function 8: numpy.concatenate
def concatenate_arrays():
    """
    Joins arrays along a given axis.

    Input: None
    Output: numpy.ndarray
    """
    arr1 = np.array([1, 2, 3])
    arr2 = np.array([4, 5, 6])
    return np.concatenate((arr1, arr2))


# Function 9: numpy.split
def split_array(arr, parts):
    return np.split(arr, parts)


# Function 10: numpy.max
def find_max_value(arr):
    return np.max(arr).tolist()


# Function 11: numpy.min
def find_min_value(arr):
    return np.min(arr).tolist()


# Function 12: numpy.mean
def calculate_mean(arr):
    return np.mean(arr).tolist()


# Function 13: numpy.std
def calculate_std(arr):
    return np.std(arr).tolist()


# Function 14: numpy.sum
def calculate_sum(arr):
    return np.sum(arr).tolist()


# Function 15: numpy.dot
def compute_dot_product(arr1, arr2):
    nparr1 = np.array(arr1)
    nparr2 = np.array(arr2)
    return np.dot(nparr1, nparr2).tolist()


# Function 16: numpy.sort
def sort_array(arr):
    return np.sort(np.array(arr)).tolist()


# Function 17: numpy.unique
def find_unique_elements(arr):
    arr = np.array(arr)
    return np.unique(arr).tolist()


# Function 18: numpy.clip
def clip_array(arr,min,max):
    arr = np.array(arr)
    return np.clip(arr, min,max).tolist()

# Function 19: numpy.argmax
def find_index_of_max_value(arr,ax = None):
    arr = np.array(arr)
    return np.argmax(arr, axis=ax).tolist()


# Function 20: numpy.vstack
def stack_arrays_vertically():
    """
    Stacks arrays vertically (row-wise).

    Input: None
    Output: numpy.ndarray
    """
    arr1 = np.array([1, 2, 3])
    arr2 = np.array([4, 5, 6])
    return np.vstack((arr1, arr2))
