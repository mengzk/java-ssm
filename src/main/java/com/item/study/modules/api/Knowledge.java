package com.item.study.modules.api;

import com.item.study.model.body.KnowledgeBody;
import com.item.study.model.dto.ListEntity;
import com.item.study.modules.network.ChatRequest;
import com.item.study.modules.network.OkResult;
import com.item.study.utils.File3;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * Author: Meng
 * Date: 2024-08-17
 * Desc: 知识库接口
 * https://bigmodel.cn/dev/api#uploadfile
 */

public class Knowledge {
    public static final MediaType fileType = MediaType.parse("multipart/form-data; charset=utf-8");

    public Knowledge() {
    }

    /**
     * 创建知识库
     * embedding_id: 知识库绑定的向量化模型, -3(固定) int
     * name: 知识库名称 <20
     * description: 知识库描述 <100字
     */
    public OkResult create(KnowledgeBody body) {
        OkResult<String> res = ChatRequest.post("/knowledge", body);
        if (res.code == 0) {
        }
        return res;
    }

    /**
     * 知识库列表
     *
     * @param page
     * @param size
     */
    public OkResult list(int page, int size) {
        OkResult<String> res = ChatRequest.get("/knowledge?page=" + page + "&size=" + size);
        if (res.code == 0) {
            return OkResult.ok(ChatRequest.jsonToBean(res.data, ListEntity.class));
        }
        return res;
    }

    /**
     * 知识库详细
     * knowledge_id
     */
    public OkResult detail(int id) {
        OkResult<String> res = ChatRequest.get("/knowledge?knowledge_id=" + id);
        if (res.code == 0) {
        }
        return res;
    }

    /**
     * 编辑知识库
     * knowledge_id: 知识库id String
     * embedding_id: 知识库绑定的向量化模型, -3(固定) int
     * name: 知识库名称 <20
     * description: 知识库描述 <100字
     */
    public OkResult update(KnowledgeBody body) {
        OkResult<String> res = ChatRequest.put("/knowledge", body);
        if (res.code == 0) {
        }
        return res;
    }

    /**
     * 知识库删除
     * knowledge_id
     */
    public OkResult delete(int id) {
        OkResult<String> res = ChatRequest.delete("/knowledge?id=" + id, null);
        if (res.code == 0) {
        }
        return res;
    }

    /**
     * 知识库容量
     */
    public OkResult capacity() {
        OkResult<String> res = ChatRequest.get("/knowledge/capacity");
        if (res.code == 0) {
//            return OkResult.ok(ChatRequest.jsonToBean(res.data, Capacity.class));
        }
        return res;
    }

    /**
     * 上传知识库文件
     * file:
     * purpose: 传文件的用途：
     *  fine-tune：用于模型微调，支持 .jsonl 文件格式，文件限制为 100 MB。微调指南
     *  batch：用于批量任务处理，支持 .jsonl 文件格式，文件限制为 100 MB。Batch指南
     *  retrieval：用于知识库检索，支持 doc、docx、pdf、xlsx 等文件格式，文件限制为 50 M。
     *  file-extract：用于文档内容抽取，支持的格式包括：PDF、DOCX、DOC、XLS、XLSX、PPT、PPTX、PNG、JPG、JPEG、CSV，文件大小不超过50M，图片大小不超过5M，总文件数不超过 100 个。
     * knowledge_id:
     * custom_separator:
     * sentence_size:
     */
    public OkResult upload(MultipartFile file, String purpose, String id) {
        File file1 = null;
        String fileName = file.getOriginalFilename();
        try {
            System.out.println("-----> type: " + file.getContentType());
            file1 = File3.getFile(file, fileName);
        } catch (IOException e) {
            e.fillInStackTrace();
            return OkResult.fail("上传文件失败");
        }
        RequestBody fileBody = RequestBody.create(file1, MediaType.parse(file.getContentType()));

        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("purpose", purpose)
                .addFormDataPart("knowledge_id", id)
                .addFormDataPart("file", fileName, fileBody)
                .build();
        OkResult<String> res = ChatRequest.upload("/files", requestBody);
        File3.delete(fileName);

        if (res.code == 0) {
        }
        return res;
    }

    /**
     * 知识库文档列表
     * purpose:
     * knowledge_id: 当文件用途为 retrieval 时，需要提供查询的知识库ID
     * page: 页面、默认 1
     * limit: 查询文件列表数，默认10
     * after:
     * order:
     */
    public OkResult docList(String purpose, Integer page, String kid) {
        OkResult<String> res = ChatRequest.get("/files" + "?purpose=" + purpose + "&page=" + page + "&knowledge_id="+kid);
        if (res.code == 0) {
        }
        return res;
    }

    /**
     * 知识库文档详细
     * id
     */
    public OkResult docDetail(String id) {
        OkResult<String> res = ChatRequest.get("/document/" + id);
        if (res.code == 0) {
        }
        return res;
    }

    /**
     * 编辑知识库文档
     * document_id: 文件id、只支持purpose为retrieval的文件
     * knowledge_type: 知识类型
     * custom_separator:
     * sentence_size:
     */
    public OkResult docUpdate(String id) {
        OkResult<String> res = ChatRequest.put("/document/" + id, null);
        if (res.code == 0) {
        }
        return res;
    }

    /**
     * 删除知识库文档
     * id:
     */
    public OkResult docDelete(String id) {
        OkResult<String> res = ChatRequest.delete("/document/" + id, null);
        if (res.code == 0) {
        }
        return res;
    }

}
