public class TreeTest
{
  public static void main(String[] args)
  {
    Tree question = new Tree("Question");
    question.addSubtree(new Tree("FillInQuestion"));

    Tree cq = new Tree("ChoiceQuestion");
    cq.addSubtree(new Tree("MultipleChoiceQuestion"));
    question.addSubtree(cq);
    question.addSubtree(new Tree("NumericalQuestion"));
    question.addSubtree(new Tree("FreeResponseQuestion"));

    System.out.println(question.getChildren(true));
    System.out.println("Nodes: " + question.size());
    System.out.println("getLeafLength: " + question.getLeafLength());

    AnnieTree();
  }

  public static void AnnieTree()
  {
    // leafs
    Tree zara = new Tree("Zara");
    Tree savannah = new Tree("Savannah");

    // parents
    Tree peter = new Tree("Peter");
    peter.addSubtree(savannah);

    // grand-parents
    Tree anne = new Tree("Anne");
    anne.addSubtree(peter);
    anne.addSubtree(zara);

    // testing
    System.out.println(anne.getChildren(true));
    System.out.println(peter.getChildren(true));
    System.out.println("getLeafLength: " + anne.getLeafLength());
  }
}
