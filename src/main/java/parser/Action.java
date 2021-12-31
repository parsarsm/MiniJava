package parser;

public class Action {
  public final act action;
  //if action = shift : number is state
  //if action = reduce : number is number of rule
  public final int number;

  public Action(act action, int number) {
    this.action = action;
    this.number = number;
  }

  public String toString() {
    switch (action) {
      case accept:
        return "acc";
      case shift:
        return "s" + number;
      case reduce:
        return "r" + number;
    }
    return action.toString() + number;
  }
}

enum act {
  shift,
  reduce,
  accept
}
