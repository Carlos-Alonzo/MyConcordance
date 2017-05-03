/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myconcordance;

/**
 *
 * @author Carlos
 */
public class MyWord {
    
    String word;
    int line;

    public MyWord(String word, int line) {
        this.word = word;
        this.line = line;
    }

    public int getLine() {
        return line;
    }

    public String getWord() {
        return word;
    }

    @Override
    public String toString() {
        return word; //To change body of generated methods, choose Tools | Templates.
    }

    public boolean equals(MyWord E) {
        return (E.getWord().equals(getWord()) && E.getLine()==getLine()); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
