package com.example.estudiosis_nb.flyiv.model;

import java.util.ArrayList;
import java.util.List;

public class DictionaryChords {

    private List<Chord> chords = new ArrayList<>();

    public DictionaryChords(){
        Chord e = new Chord("E", 450);
        this.chords.add(e);

        Chord f = new Chord("F", 450);
        this.chords.add(f);

        Chord f_sus = new Chord("F#", 450);
        this.chords.add(f_sus);

        Chord g = new Chord("G", 450);
        this.chords.add(g);

        Chord g_sus = new Chord("G#", 450);
        this.chords.add(g_sus);

        Chord a = new Chord("A", 450);
        this.chords.add(a);

        Chord a_sus = new Chord("A#", 450);
        this.chords.add(a_sus);

        Chord b = new Chord("B", 450);
        this.chords.add(b);

        Chord b_m = new Chord("Bm", 450);
        this.chords.add(b_m);

        Chord c = new Chord("C", 450);
        this.chords.add(c);

        Chord c_sus = new Chord("C#", 450);
        this.chords.add(c_sus);

        Chord d = new Chord("D", 450);
        this.chords.add(d);

        Chord eb = new Chord("Eb", 450);
        this.chords.add(eb);
    }

    public Chord getChord(int position) {
        return this.chords.get(position);
    }

}
