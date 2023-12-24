package br.com.alfa11.hashtools.service;

import br.com.alfa11.hashtools.util.HashUtil;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

@Service
public class HashToolsService {

    public String getHash(String algoritmo, String plainText){
        String result = "";
        String erro = "Erro: Não SUportado";
        try{
            switch (algoritmo){
                case "SHA-256":
                    result = HashUtil.getHashSHA256(plainText);
                    return result;
                case "SHA3-256":
                    result = HashUtil.getHashSHA3256(plainText);
                    return result;
                case "MD5":
                    result = HashUtil.getHashMD5(plainText);
                    return result;
                default:
                    return erro;
            }

        }catch(NoSuchAlgorithmException e){
            e.printStackTrace();
            return erro;
        }catch(UnsupportedEncodingException e1){
            e1.printStackTrace();
            return erro;
        }

    }
}
