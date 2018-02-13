package tripadvisor;

import java.util.Arrays;
import java.util.List;

public class BalancedBrackets {

  public static void main(String[] args){

    List<String> inputs = Arrays.asList(
        "()[{}()]([[][]()[[]]]{()})([]()){[]{}}{{}}{}(){([[{}([]{})]])}",
        "{][({(}]][[[{}]][[[())}[)(]([[[)][[))[}[]][()}))](]){}}})}[{]{}{((}]}{{)[{[){{)[]]}))]()]})))[",
        "[)](][[([]))[)",
        "]}]){[{{){",
        "{[(}{)]]){(}}(][{{)]{[(((}{}{)}[({[}[}((}{()}[]})]}]]))((]][[{{}[(}})[){()}}{(}{{({{}[[]})]{((]{[){[",
        "()}}[(}])][{]{()([}[}{}[{[]{]](]][[))(()[}(}{[{}[[]([{](]{}{[){()[{[{}}{[{()(()({}([[}[}[{(]})",
        "){[])[](){[)}[)]}]]){](]()]({{)(]])(]{(}(}{)}])){[{}((){[({(()[[}](]})]}({)}{)]{{{",
        "[(})])}{}}]{({[]]]))]})]",
        "[{",
        "{}([{()[]{{}}}])({})",
        "{({}{[({({})([[]])}({}))({})]})}",
        "()[]",
        "{)[])}]){){]}[(({[)[{{[((]{()[]}][([(]}{](])()(}{(]}{})[)))[](){({)][}()((",
        "[][(([{}])){}]{}[()]{([[{[()]({}[])()()}[{}][]]])}",
        "(}]}",
        "(([{()}]))[({[{}{}[]]{}})]{((){}{()}){{}}}{}{{[{[][]([])}[()({}())()({[]}{{[[]]([])}})()]]}}",
        "[(([){[](}){){]]}{}([](([[)}[)})[(()[]){})}}]][({[}])}{(({}}{{{{])({]]}[[{{(}}][{)([)]}}",
        "()()[()([{[()][]{}(){()({[]}[(((){(())}))]()){}}}])]",
        "({)}]}[}]{({))}{)]()(](])})][(]{}{({{}[]{][)){}{}))]()}((][{]{]{][{}[)}}{)()][{[{{[[",
        ")}(()[])(}]{{{}[)([})]()}()]}(][}{){}}})}({](){([()({{(){{",
        "}([]]][[){}}[[)}[(}(}]{(}[{}][{}](}]}))]{][[}(({(]}[]{[{){{(}}[){[][{[]{[}}[)]}}]{}}(}"
    );

    inputs.forEach(expression -> System.out.println( (isBalancedRec(expression)) ? "YES" : "NO" ));

  }

  public static boolean isBalancedRec(String expression) {

    final String exp = expression.replaceAll("\\(\\)","").replaceAll("\\[\\]","").replaceAll("\\{\\}","");

    if(exp.length() < expression.length()){
      return isBalancedRec(exp);
    }else{
      return exp.isEmpty();
    }
  }

}