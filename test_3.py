import pytest

@pytest.fixture
def test_name():
    return "krishna"

def test_call(test_name):
    print test_name
    
@pytest.mark.parametrize("x,y", [(1,3), (1,5), (1,4), (1,2)])
def test_foo(x, y):
    print x+y
