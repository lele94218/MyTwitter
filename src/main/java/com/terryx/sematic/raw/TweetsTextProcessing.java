package com.terryx.sematic.raw;

import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.core.StopFilter;
import org.apache.lucene.analysis.en.PorterStemFilter;
import org.apache.lucene.analysis.standard.StandardTokenizer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.util.CharArraySet;
import org.apache.lucene.util.Version;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by xueta on 2016/3/24.
 */
public class TweetsTextProcessing {
    static CharArraySet stopWords = new CharArraySet(Version.LUCENE_43, 1000, true);

    static {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("F:\\JavaWorks\\MyTwitter\\src\\main\\resources\\english.stop"));
            String line = "";
            while ((line = br.readLine()) != null) {
                stopWords.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 转小写, 去除无关字符 (非 [a-z])
     *
     * @param _s
     * @return
     */
    public static String processingBeforeTokenize(String _s) {
        String str = _s;
        // 全部转小写
        str = str.toLowerCase();
        // 正则去除无关字符
        str = str.replaceAll("[^a-z\\s]", "");
        // 正则去除 http 开头
        str = str.replaceAll("\\bhttp\\w*\\b", "");
        return str;
    }

    /**
     * 去除 stop words, 文件为 english.stop
     * 进行 Stemming 操作, 即: 将 cats --> cat
     *
     * @param _s
     * @return
     * @throws IOException
     */
    public static String tokenzieStopStem(String _s) throws IOException {
        TokenStream tokenStream = new StandardTokenizer(Version.LUCENE_43, new StringReader(_s));
        // Stop words removal
        tokenStream = new StopFilter(Version.LUCENE_43, tokenStream, stopWords);
        // Stemming
        tokenStream = new PorterStemFilter(tokenStream);

        StringBuilder sb = new StringBuilder();

        CharTermAttribute charTermAttribute = tokenStream.addAttribute(CharTermAttribute.class);
        tokenStream.reset();
        while (tokenStream.incrementToken()) {
            if (sb.length() > 0) {
                sb.append(" ");
            }
            sb.append(charTermAttribute.toString());
        }

        return sb.toString();
    }


    /**
     * 执行文本处理操作
     *
     * @param _s
     * @return 单词集合
     */
    public static Set<String> doTweetsTextProcessing(String _s) throws IOException {
        _s = processingBeforeTokenize(_s);
        _s = tokenzieStopStem(_s);

        Set<String> stringSet = new HashSet<String>();
        String[] strs = _s.split(" ");
        for (String s : strs) {
            if (!s.equals("")) {
                stringSet.add(s);
            }
        }
        return stringSet;
    }




}
