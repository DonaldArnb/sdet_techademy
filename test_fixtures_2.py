import pytest


# Arrange
#Fixturewith decorator building a dictionary
@pytest.fixture
def customer_fixture():
    data = {"first_name": "Arnab",
            "surname": "Purakayestha" }
    return data

#Assert customer name which should pass
def test_CustomerName(customer_fixture):
    print(customer_fixture)
    assert customer_fixture["first_name"] == "Arnab"
    assert customer_fixture["surname"] == "Purakayestha"       



# Arrange
@pytest.fixture
def age():
    return 35


# Arrange
@pytest.fixture
def order(customer_fixture, age):
    return [customer_fixture, age]


# Arrange
@pytest.fixture
def expected_list():
    return ["Arnab", 35, 10]


def test_string(order, expected_list):
    # Act
    order.append(11)

    # Assert -- This should fail the assertionas appended value '11' doesn't match expected value '10'
    assert order == expected_list
