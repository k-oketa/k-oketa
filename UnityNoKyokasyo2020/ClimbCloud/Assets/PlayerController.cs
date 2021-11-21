using System;
using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class PlayerController : MonoBehaviour
{
    private Rigidbody2D rigidBody;
    private Animator animator;
    private float jumpForce = 680.0f;
    private float walkForce = 30.0f;
    private float maxWalkSpeed = 2.0f;
    
    // Start is called before the first frame update
    void Start()
    {
        this.rigidBody = GetComponent<Rigidbody2D>();
        this.animator = GetComponent<Animator>();
    }

    // Update is called once per frame
    void Update()
    {
        if (Input.GetKeyDown(KeyCode.Space))
        {
            this.rigidBody.AddForce(transform.up * this.jumpForce);
        }

        var key = 0;
        if (Input.GetKey(KeyCode.RightArrow)) key = 1;
        if (Input.GetKey(KeyCode.LeftArrow)) key = -1;

        var speedx = Mathf.Abs(this.rigidBody.velocity.x);

        if (speedx < this.maxWalkSpeed)
        {
            this.rigidBody.AddForce(transform.right * key * this.walkForce);
        }

        if (key != 0)
        {
            transform.localScale = new Vector3(key, 1, 1);
        }

        this.animator.speed = speedx / 2.0f;
    }

    private void OnTriggerEnter2D(Collider2D other)
    {
        Debug.Log("Goal!");
    }
}
